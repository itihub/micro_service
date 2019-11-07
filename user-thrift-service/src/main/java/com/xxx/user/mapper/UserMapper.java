package com.xxx.user.mapper;

import com.xxx.thrift.user.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: Jimmy
 */
@Repository
public interface UserMapper {

    /**
     * 根据ID获取用户信息
     * @param id 用户编号
     * @return
     */
    @Select("SELECT id, username, password, real_name, mobile, email FROM pe_user WHERE id = #{id}")
    UserInfo getUserById(@Param("id") Integer id);

    /**
     * 根据用户昵称获取用户信息
     * @param username 用户昵称
     * @return
     */
    @Select("SELECT id, username, password, real_name, mobile, email FROM pe_user WHERE username = #{username}")
    UserInfo getUserByUsername(@Param("username") String username);

    /**
     * 新增用户
     * @param userInfo
     */
    @Insert("INSERT INTO pe_user (username, password, real_name, mobile, email) VALUES " +
            "(#{userInfo.username}, #{userInfo.password}, #{userInfo.realName}, #{userInfo.mobile}, #{userInfo.email})")
    void insertUser(@Param("userInfo") UserInfo userInfo);

    /**
     * 根据用户编号获取用户课程信息
     * @param id
     * @return
     */
    @Select("SELECT u.id,u.username,u.password,u.real_name, u.mobile, u.email, t.intro, t.stars " +
            "FROM pe_user u, pe_teacher t  " +
            "WHERE u.id= #{id} and u.id = t.user_id")
    UserInfo getTeacherById(@Param("id")Integer id);
}
