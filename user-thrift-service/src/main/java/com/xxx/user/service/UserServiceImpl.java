package com.xxx.user.service;

import com.xxx.thrift.user.UserInfo;
import com.xxx.thrift.user.UserService;
import com.xxx.user.mapper.UserMapper;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户信息服务实现
 * @Author: Jimmy
 */
@Service
public class UserServiceImpl implements UserService.Iface {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfo getUserById(int id) throws TException {
        return userMapper.getUserById(id);
    }

    @Override
    public UserInfo getTeacherById(int id) throws TException {
        return userMapper.getTeacherById(id);
    }

    @Override
    public UserInfo getUserByName(String username) throws TException {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public void regiserUser(UserInfo userInfo) throws TException {
        userMapper.insertUser(userInfo);
    }
}
