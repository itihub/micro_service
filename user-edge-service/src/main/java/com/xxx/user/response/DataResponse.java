package com.xxx.user.response;

import lombok.Data;

/**
 * @Description: 数据响应
 * @Author: Jimmy
 */
@Data
public class DataResponse extends Response {

    private Object data;

    public DataResponse() {
    }

    public DataResponse(Object data) {
        this.data = data;
    }
}
