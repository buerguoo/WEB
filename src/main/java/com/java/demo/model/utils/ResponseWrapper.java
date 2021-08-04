package com.java.demo.model.utils;

import java.util.List;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

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
        String returnString = "ResponseWrapper{" +
                "status='" + code + '\'' +
                ", message='" + message + '\'';
        if (data instanceof List) {
            if(((List) data).size()>5){
                return returnString +
                        ", dataSize=" + ((List) data).size() +
                        '}';
            }
        } else if (data instanceof PageResult) {
            if (CollectionUtils.isEmpty(((PageResult) data).getData())) {
                return returnString +
                        ", totalCount=" + ((PageResult) data).getTotalCount() +
                        ", dataSize=" + 0 +
                        '}';
            }
            return returnString +
                    ", totalCount=" + ((PageResult) data).getTotalCount() +
                    ", dataSize=" + ((PageResult) data).getData().size() +
                    '}';
        }
        return "ResponseWrapper{" +
                "status='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
	
}
