package com.snkit.springboottest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguration {

	

	
	@Bean
	public TestService testService() {
		
		
		
		return new TestService();
	}
}
