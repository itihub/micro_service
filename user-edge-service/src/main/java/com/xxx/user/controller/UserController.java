package com.xxx.user.controller;

import com.xxx.thrift.user.UserInfo;
import com.xxx.user.constants.KetPrefixConstants;
import com.xxx.user.enums.ResponseEnum;
import com.xxx.user.response.DataResponse;
import com.xxx.user.response.Response;
import com.xxx.user.thrift.ServiceProvider;
import com.xxx.user.utils.MD5Util;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

/**
 * @Description: TODO
 * @Author: Jimmy
 */
@Controller
public class UserController {

    @Autowired
    private ServiceProvider serviceProvider;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public Response login(@RequestParam("username") String username,
                          @RequestParam("password") String password){
        //1验证用户名密码
        UserInfo userInfo = null;
        try {
            userInfo = serviceProvider.getUserService().getUserByName(username);
        } catch (TException e) {
            e.printStackTrace();
            return new Response(ResponseEnum.USERNAME_PASSWORD_INVALID);
        }
        if (userInfo == null){
            return new Response(ResponseEnum.USERNAME_PASSWORD_INVALID);
        }
        if (!userInfo.getPassword().equals(MD5Util.encrypt(password))){
            return new Response(ResponseEnum.USERNAME_PASSWORD_INVALID);
        }

        //2生成token
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        //3缓存用户
        String key = String.format(KetPrefixConstants.KEY_ACCESS_TOKEN, userInfo.getId());
        redisTemplate.opsForHash().hasKey(key, userInfo);

        return new DataResponse(token);
    }
}
