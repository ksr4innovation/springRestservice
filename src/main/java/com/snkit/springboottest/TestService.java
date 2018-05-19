package com.snkit.springboottest;

public class TestService {
	
private int count;
	
	public void show() {
		
		
		
		System.out.println("  From TestService"+count++);
		
		if (count == 1 || count == 3 || count == 5)  {
			throw new TestException("Test001"," Exception occured while processing");
		}
		
		
		
	}
}
