package com.snkit.springboottest;

import java.io.Serializable;

public class ErrorResponse implements Serializable{
	
	private String id;
	
	private String message;
	
	

/*	public ErrorResponse(String id, String message) {
		super();
		this.id = id;
		this.message = message;
	}*/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
