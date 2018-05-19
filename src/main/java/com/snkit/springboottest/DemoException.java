package com.snkit.springboottest;

public class DemoException extends RuntimeException {
	
	private String id;
	
	private String message;
	
	
	

	public DemoException(String id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

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
