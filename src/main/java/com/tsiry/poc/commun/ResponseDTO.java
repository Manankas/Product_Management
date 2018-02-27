package com.tsiry.poc.commun;

public class ResponseDTO {
	private String Message;
	private Object p;
	
	
	public ResponseDTO(String message, Object p) {
		super();
		Message = message;
		this.p = p;
	}


	public String getMessage() {
		return Message;
	}


	public void setMessage(String message) {
		Message = message;
	}


	public Object getP() {
		return p;
	}


	public void setP(Object p) {
		this.p = p;
	}
	
	
	
}
