package com.snkit.springboottest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	

	@Autowired
	TestService testService ;
	
	@Autowired
	DemoService demoService ;
	
	@Autowired
	@Qualifier("currentAccount")
	Account account;
	
	@Autowired
	@Qualifier("savingAccount")
	Account account1;
	
	@GetMapping(value="/user",consumes= {"application/json","application/xml"}
	,produces= {"application/json","application/xml"})
	public UserResp getUsers(){
		
		
		//testService.show();
		
		
		account.accountDetails();
		
		UserResp userResp  = new UserResp();
		User u = new User();
		u.setCompnayName("Company ATest");
		u.setName("Test222");
		
		User u1 = new User();
		u1.setCompnayName("Company ATest");
		u1.setName("Test333");
		
		userResp.getUserList().add(u);
		userResp.getUserList().add(u1);
		return userResp;
	}
	
	
	@GetMapping(value="/user",
			consumes= {"application/vnd.snkit-v1+json","application/vnd.snkit-v1+xml"}
			, produces= {"application/vnd.snkit-v1+json","application/vnd.snkit-v1+xml"})
	public UserResp getUser(){
		
	//	demoService.show();
		
		account1.accountDetails();
		
		UserResp userResp  = new UserResp();
		User u = new User();
		u.setCompnayName("Company B Test");
		u.setName("Test222");
		
		User u1 = new User();
		u1.setCompnayName("Company B Test");
		u1.setName("Test333");
		
		userResp.getUserList().add(u);
		userResp.getUserList().add(u1);
		return userResp;
	}

}
