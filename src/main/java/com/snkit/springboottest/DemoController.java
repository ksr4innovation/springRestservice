package com.snkit.springboottest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	
	
	@GetMapping(value="/user",
			consumes= {"application/vnd.snkit-v2+json","application/vnd.snkit-v2+xml"}
			, produces= {"application/vnd.snkit-v2+json","application/vnd.snkit-v2+xml"})
	public UserResp findAllUsers(){
	     return demoService.getUsers();
	}
	
	@PostMapping(value="/addUser",
			consumes= {"application/json","application/xml"}
			, produces= {"application/json","application/xml"})
	public ResponseEntity<HttpStatus> addUser(@RequestBody User user){
		 demoService.addUser(user);
	     return  new ResponseEntity(HttpStatus.OK);
	}
	
	
	@PostMapping(value="/findByName",
			consumes= {"application/json","application/xml"}
			, produces= {"application/json","application/xml"})
	public UserResp findByName(@RequestBody User user){
		 return demoService.findByName(user);
	}
	
	@PostMapping(value="/getUserByName",
			consumes= {"application/json","application/xml"}
			, produces= {"application/json","application/xml"})
	public UserResp getUserByName(@RequestBody User user){
		 return demoService.getUserByName(user);
	}
	
	@PostMapping(value="/getUserByParam",
			consumes= {"application/json","application/xml"}
			, produces= {"application/json","application/xml"})
	public UserResp getUserByParam(@RequestBody User user){
		 return demoService.getUserByParam(user);
	}
	
	@PostMapping(value="/getUsers",
			consumes= {"application/json","application/xml"}
			, produces= {"application/json","application/xml"})
	public UserResp getUsers(@RequestBody User user){
		 return demoService.getUsers(user);
	}
}
