package com.xxx.user.service;

import com.xxx.thrift.user.UserInfo;

/**
 * @Description: TODO
 * @Author: JiZhe
 */
public interface UserService {

    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    UserInfo register();
}
