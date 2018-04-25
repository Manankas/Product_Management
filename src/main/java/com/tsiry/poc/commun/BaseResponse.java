package com.tsiry.poc.commun;

public class BaseResponse {
	private String Message;
	
	public BaseResponse(String message) {
		super();
		Message = message;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	
}
