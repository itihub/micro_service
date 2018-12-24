package com.xxx.user.controller;

import com.xxx.thrift.user.UserInfo;
import com.xxx.thrift.user.domain.dto.UserDTO;
import com.xxx.user.config.RedisClient;
import com.xxx.user.constants.KetPrefixConstants;
import com.xxx.user.enums.ResponseEnum;
import com.xxx.user.response.DataResponse;
import com.xxx.user.response.Response;
import com.xxx.user.service.UserService;
import com.xxx.user.thrift.ServiceProvider;
import com.xxx.user.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: TODO
 * @Author: Jimmy
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private ServiceProvider serviceProvider;

    @Autowired
    private RedisClient redisClient;


    @GetMapping("/login")
    public String login(){
        return "login";
    }


    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public Response login(@RequestParam("username") String username,
                          @RequestParam("password") String password){

        if (StringUtils.isBlank(username) && StringUtils.isBlank(password)){
            return new Response(ResponseEnum.PARAM_ERROR);
        }

        String token = userService.login(username, password);
        return new DataResponse(token);
    }


    @PostMapping("/register")
    @ResponseBody
    public Response register(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam(value = "mobile", required = false) String mobile,
                             @RequestParam(value = "email", required = false) String email,
                             @RequestParam("verifyCode") String verifyCode){

        if (StringUtils.isBlank(mobile) && StringUtils.isBlank(email)){
            return new Response(ResponseEnum.NO_MOBILE_OR_EMAIL_REQUIRED);
        }

        String code = null;
        if (StringUtils.isNotBlank(mobile)){
            code = redisClient.get(String.format(KetPrefixConstants.KEY_VERIFY_CODE, mobile));
        }else {
            code = redisClient.get(String.format(KetPrefixConstants.KEY_VERIFY_CODE, email));
        }
        if (!verifyCode.equals(code)){
            return new Response(ResponseEnum.VERIFY_CODE_INVALID);
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(MD5Util.encrypt(password));
        userInfo.setMobile(mobile);
        userInfo.setEmail(email);
        try {
            serviceProvider.getUserService().regiserUser(userInfo);
        } catch (TException e) {
            e.printStackTrace();
            return new Response(ResponseEnum.SERVER_ERROR);
        }

        return new DataResponse();
    }

    @ResponseBody
    @PostMapping("/sendVerifyCode")
    public Response sendVerifyCode(@RequestParam(value = "mobile", required = false) String mobile,
                                   @RequestParam(value = "email", required = false) String email){
        String numeric = RandomStringUtils.randomNumeric(6);
        String message = String.format("Verify code is %s", numeric);
        Boolean boo = false;
        try {
            if (StringUtils.isNotBlank(mobile)){
                boo = serviceProvider.getMessageService().sendMoblieMessage(mobile, message);
                redisClient.set(String.format(KetPrefixConstants.KEY_VERIFY_CODE, mobile), numeric, 600);
            }else if (StringUtils.isNotBlank(email)){
                boo = serviceProvider.getMessageService().sendEmailMessages(email, message);
                redisClient.set(String.format(KetPrefixConstants.KEY_VERIFY_CODE, email), numeric, 600);
            }else {
                return new Response(ResponseEnum.NO_MOBILE_OR_EMAIL_REQUIRED);
            }

            if (!boo){
                return new Response(ResponseEnum.SEND_VERIFY_CODE_FAILED);
            }
        }catch (TException e){
            log.error("【信息服务失败】 ", e);
            return new Response(ResponseEnum.SEND_VERIFY_CODE_FAILED);
        }

        return new DataResponse(boo);
    }

    @ResponseBody
    @PostMapping("/authentication")
    public UserDTO authentication(@RequestHeader("token") String token){
        String key = String.format(KetPrefixConstants.KEY_ACCESS_TOKEN, token);
        return redisClient.get(key);

    }


}
