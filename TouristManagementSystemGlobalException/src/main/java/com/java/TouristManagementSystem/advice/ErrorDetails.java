package com.java.TouristManagementSystem.advice;

import java.time.LocalDateTime;

public class ErrorDetails 
{
	private String statusCode;
	private String msg;
	private LocalDateTime datetime;
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	public ErrorDetails(String statusCode, String msg, LocalDateTime datetime) {
		super();
		this.statusCode = statusCode;
		this.msg = msg;
		this.datetime = datetime;
	}
}
