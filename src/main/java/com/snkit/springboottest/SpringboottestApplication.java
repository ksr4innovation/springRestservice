package com.snkit.springboottest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringboottestApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringboottestApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		System.out.println("   from commandline runner run method ");
		
		List<UserEntity> userList = new ArrayList<UserEntity>();
		
		for (int i =0;i<20;i++) {
			
			UserEntity entity = new UserEntity();
			entity.setDesg("STE"+i);
			entity.setName("DemoTEST "+i);
			
			userList.add(entity);
			
		}
		
		
		userRepository.save(userList);
		
	}
	

}
