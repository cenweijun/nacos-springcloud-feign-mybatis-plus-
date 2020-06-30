package com.mycen.nacos.nacosprovider8081.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

//统一服务器响应数据的格式
//利用注释将null的不显示
/*@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)*/
public class ServerResponse<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8014940774503712683L;
	
	//封装三个对象的数据
	private Integer status;
	
	private String msg;
	private T date;//数据类型不确定，所以是泛型
	
	public  boolean isSuccess() {
		
		return this .status==ResponseCode.SUCCESS.getCode();
	}
	
	
	
	public ServerResponse() {
		super();
	}
	public ServerResponse(Integer status) {
		super();
		this.status = status;
	}
	
	public ServerResponse(Integer status, T date) {
		super();
		this.status = status;
		this.date = date;
	}
	public ServerResponse(Integer status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}
	public ServerResponse(Integer status, String msg, T date) {
		super();
		this.status = status;
		this.msg = msg;
		this.date = date;
	}
	
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getDate() {
		return date;
	}
	public void setDate(T date) {
		this.date = date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	//当把ResponCode枚举类写好，可以在当前类中定义多几个静态方法
	public static <T> ServerResponse<T> createBySuccess(){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
	}
	public  static <T>ServerResponse<T> createBySuccessMessage(String msg){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
	}
	public static <T> ServerResponse<T> createBySuccess(T date){
		return  new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),date);
	}
	public static <T> ServerResponse<T>createBySuccess(String msg,T date){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,date);
	}
	
	//失败响应
	public static <T> ServerResponse<T> createByError(ResponseCode responseCode)
	{
		ServerResponse<T> serverResponse=new ServerResponse<>(responseCode.ARGUMENTS_ERROR.getCode());
		serverResponse.setMsg(responseCode.getMsg());
		return serverResponse;
	}
	public static <T> ServerResponse<T> createByError()
	{
		return new ServerResponse<T>(ResponseCode.ERROR.getCode());
	}
	
	public static <T> ServerResponse<T> createByErrorMessage(String msg)
	{
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(),msg);
	}
	public static <T> ServerResponse<T> createByErrorCodeMessage(Integer code,String msg)
	{
		return new ServerResponse<T>(code,msg);
	}

}
