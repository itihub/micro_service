package com.xxx.user.service.impl;

import com.xxx.thrift.user.UserInfo;
import com.xxx.thrift.user.domain.dto.UserDTO;
import com.xxx.user.config.RedisClient;
import com.xxx.user.constants.KetPrefixConstants;
import com.xxx.user.enums.ResponseEnum;
import com.xxx.user.exception.UserEdgeException;
import com.xxx.user.service.UserService;
import com.xxx.user.thrift.ServiceProvider;
import com.xxx.user.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Description: TODO
 * @Author: JiZhe
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ServiceProvider serviceProvider;

    @Autowired
    private RedisClient redisClient;


    @Override
    public String login(String username, String password) {

        //1验证用户名密码
        UserInfo userInfo = null;
        try {
            userInfo = serviceProvider.getUserService().getUserByName(username);
        } catch (TException e) {
            e.printStackTrace();
            throw  new UserEdgeException(ResponseEnum.USERNAME_PASSWORD_INVALID);
        }
        if (userInfo == null){
            throw  new UserEdgeException(ResponseEnum.USERNAME_PASSWORD_INVALID);
        }
        if (!userInfo.getPassword().equals(MD5Util.encrypt(password))){
            throw  new UserEdgeException(ResponseEnum.USERNAME_PASSWORD_INVALID);
        }

        //2生成token
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        //3缓存用户
        String key = String.format(KetPrefixConstants.KEY_ACCESS_TOKEN, userInfo.getId());
        redisClient.set(key, toDTO(userInfo), 3600);
        return token;
    }

    @Override
    public UserInfo register() {
        return null;
    }

    private UserDTO toDTO(UserInfo userInfo){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userInfo, userDTO);
        return userDTO;
    }
}
