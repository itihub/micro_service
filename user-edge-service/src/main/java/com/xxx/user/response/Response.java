package com.xxx.user.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.xxx.user.enums.ResponseEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 状态响应
 * @Author: Jimmy
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response implements Serializable {

    private Integer code;

    private String messages;

    public Response(ResponseEnum responseEnum){
        this.code = responseEnum.getCode();
        this.messages = responseEnum.getMessages();
    }

    public Response(Integer code, String messages) {
        this.code = code;
        this.messages = messages;
    }

    public Response() {
    }
}
