package com.snkit.springboottest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages= {"com.snkit.*","com.abc.*"})
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
		
		for (int i =1;i<20;i++) {
			
			UserEntity entity = new UserEntity();
			entity.setDesg("STE"+i);
			entity.setName("DemoTEST "+i);
			
			for (int j =1;j<3;j++) {
				AddressEntity add = new AddressEntity();				
				add.setCity("city"+i);
				add.setState("state"+i);
				add.setStreet("stree"+i);
				
				// The below statement only give id's 
				add.setUserEntity(entity);
				
				entity.getAddressList().add(add);
				
			}
			
			userList.add(entity);
			
		}
		
		
		userRepository.save(userList);
		
	}
	

}
