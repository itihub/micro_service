package com.xxx.thrift.user.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author: JiZhe
 */
@Data
public class UserDTO implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private String mobile;

    private String email;

    private String realName;


}
