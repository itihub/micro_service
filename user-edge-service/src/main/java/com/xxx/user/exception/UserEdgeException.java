package com.xxx.user.exception;

import com.xxx.user.enums.ResponseEnum;

/**
 * @Description: TODO
 * @Author: JiZhe
 */
public class UserEdgeException extends RuntimeException {

    private Integer code;

    public UserEdgeException(ResponseEnum responseEnum){
        super(responseEnum.getMessages());
        this.code = responseEnum.getCode();
    }
}
