package com.mycen.nacos.nacosprovider8081.common;

public enum ResponseCode {
	SUCCESS(0,"success"),
	ERROR(1,"error"),
	NEED_LOHIN(10,"need_login"),
	ARGUMENTS_ERROR(2,"参数错误！");
	
	private Integer code;
	private String msg;
	private ResponseCode(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
