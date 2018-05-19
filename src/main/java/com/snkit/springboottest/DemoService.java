package com.snkit.springboottest;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

	private int count;
	
	public void show() {
		
		System.out.println("  From DemoService"+count++);
		
		if (count == 1 || count == 3 || count == 5)  {
			throw new DemoException("D001"," Exception occured while processing");
		}
		
	}
}
