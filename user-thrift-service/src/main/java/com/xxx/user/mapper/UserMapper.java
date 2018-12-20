package com.xxx.user.mapper;

import com.xxx.thrift.user.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Description: TODO
 * @Author: Jimmy
 */
@Mapper
public interface UserMapper {

    @Select("SELECT id, username, password, real_name, mobile, email FROM pe_user WHERE id = #{id}")
    UserInfo getUserById(@Param("id") Integer id);

    @Select("SELECT id, username, password, real_name, mobile, email FROM pe_user WHERE username = #{username}")
    UserInfo getUserByUsername(@Param("username") String username);


    @Insert("INSERT INTO pe_user (username, password, real_name, mobile, email) VALUES " +
            "(#{userInfo.username}, #{userInfo.password}, #{userInfo.realName}, #{userInfo.mobile}, #{userInfo.email})")
    void insertUser(UserInfo userInfo);

    @Select("SELECT u.id,u.username,u.password,u.real_name, u.mobile, u.email, t.intro, t.stars " +
            "FROM pe_user u, pe_teacher t  " +
            "WHERE u.id= #{id} and u.id = t.user_id")
    UserInfo getTeacherById(@Param("id")Integer id);
}
