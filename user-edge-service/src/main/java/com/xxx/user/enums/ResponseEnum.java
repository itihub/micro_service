package com.xxx.user.enums;

import lombok.Getter;

/**
 * @Description: TODO
 * @Author: Jimmy
 */
@Getter
public enum ResponseEnum {

    USERNAME_PASSWORD_INVALID(1001, "username or password invalid"),
    ;

    private Integer code;

    private String messages;

    ResponseEnum(Integer code, String messages) {
        this.code = code;
        this.messages = messages;
    }
}
