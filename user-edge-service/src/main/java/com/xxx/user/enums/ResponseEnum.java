package com.xxx.user.enums;

import lombok.Getter;

/**
 * @Description: TODO
 * @Author: Jimmy
 */
@Getter
public enum ResponseEnum {
    SERVER_ERROR(9999, "server error"),
    PARAM_ERROR(1111, "param check failed"),
    USERNAME_PASSWORD_INVALID(1001, "username or password invalid"),
    NO_MOBILE_OR_EMAIL_REQUIRED(1002, "mobile or email is required"),
    SEND_VERIFY_CODE_FAILED(1003, "send verify code failed"),
    VERIFY_CODE_INVALID(1004, "verifyCode invalid"),
    ;

    private Integer code;

    private String messages;

    ResponseEnum(Integer code, String messages) {
        this.code = code;
        this.messages = messages;
    }
}
