package com.snkit.springboottest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.abc.dependency.externaldepencyconfig.ExternalDependencyService;

@Configuration
public class DemoConfiguration {

	@Bean
	public TestService testService() {
		externalDependencyService.show();
		
		return new TestService();
	}
	
	@Autowired
	ExternalDependencyService externalDependencyService;
}
