package com.java.demo.model.utils;

import io.swagger.annotations.ApiModelProperty;

public class ResponseWrapper<T> {
	
	@ApiModelProperty("状态码")
    private String code = ResponseStatus.OK.getValue();

    @ApiModelProperty("信息")
    private String message = "success";

    @ApiModelProperty("接口返回数据")
    private T data;

    public ResponseWrapper(ResponseStatus status, String message) {
        this.code = status.getValue();
        this.message = message;
    }

    public ResponseWrapper(ResponseStatus status, T data) {
        this.code = status.getValue();
        this.data = data;
    }

    public ResponseWrapper(ResponseStatus status, String message, T data) {
        this.code = status.getValue();
        this.message = message;
        this.data = data;
    }

    public ResponseWrapper(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(ResponseStatus status) {
        this.code = status.getValue();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
    	
        return "ResponseWrapper{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
	
}
