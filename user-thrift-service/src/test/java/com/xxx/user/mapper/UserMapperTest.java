package com.xxx.user.mapper;

import com.xxx.thrift.user.UserInfo;
import com.xxx.user.UserServiceApplicationTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: TODO
 * @Author: Jimmy
 */
public class UserMapperTest extends UserServiceApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUserById() {
        UserInfo user = userMapper.getUserById(1);
        Assert.assertNotNull(user);
    }

    @Test
    public void getUserByUsername() {
        UserInfo user = userMapper.getUserByUsername("jimmy");
        Assert.assertNotNull(user);
    }

    @Test
    public void insertUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("当妮");
        userInfo.setPassword("abcd");
        userInfo.setRealName(null);
        userInfo.setEmail("dangni@example.com");
        userInfo.setMobile("15551235555");
        userMapper.insertUser(userInfo);
    }

    @Test
    public void getTeacherById() {
    }
}
