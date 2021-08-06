package com.java.demo.model.utils;

public enum ResponseStatus {
	
	 /**
     *  请求成功状态码
     */
    OK("1010","success"),

    /**
     * 请求失败
     */
    FAIL_4000("4000","FILE"),

    /**
     *  未认证
     */
    FAIL_4001("4001","未认证"),

    /**
     * 无权限
     */
    FAIL_4003("4003","无权限"),

    FAIL_6001("6001","发布文章超过当日次数"),
	
	/**
     * 密码错误
	 */
	FAIL_2008("2008", "密码错误"),
	
	/**
     *用户名错误 
	 */
	FIAL_2007("2007", "用户名错误");
	
    private final String value;

    private final String reasonPhrase;

    ResponseStatus(String value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public String getValue() {
        return value;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }
	
}
