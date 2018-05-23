package com.snkit.springboottest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DemoService {

	private int count;
	
	public void show() {
		
		System.out.println("  From DemoService"+count++);
		
		if (count == 1 || count == 3 || count == 5)  {
			throw new DemoException("D001"," Exception occured while processing");
		}
		
	}
	
	
	private UserRepository userRepository;
	
	public DemoService( UserRepository userRepository) {
		this.userRepository  = userRepository;
	}
	
	public UserResp getUsers() {
		UserResp resp = new UserResp();
		List<UserEntity> list = userRepository.findAll(); 
		
		list.stream().forEach(useEntity -> {
			User user = new User();
			user.setCompnayName(useEntity.getDesg());
			user.setName(useEntity.getName());
			
		/*	
			useEntity.getAddressList().stream().forEach(addEntity ->{
				AddressVO add = new AddressVO();
				add.setCity(addEntity.getCity());
				add.setState(addEntity.getState());
				add.setStreet(addEntity.getStreet());
				user.getAddList().add(add);
				
			});*/
			
			resp.getUserList().add(user);
		});
		
		
		return resp;
	}
	
	public void addUser(User user) {		
		UserEntity entity = new UserEntity();
		entity.setDesg(user.getCompnayName());
		entity.setName(user.getName());	
		user.getAddList().stream().forEach(addressVO -> {			
			AddressEntity add = new AddressEntity();
			add.setCity(addressVO.getCity());
			add.setState(addressVO.getState());
			add.setStreet(addressVO.getStreet());
			
			add.setUserEntity(entity);
			
			entity.getAddressList().add(add);
			
		});
		userRepository.save(entity);
	}
	
	
	
	public UserResp findByName(User userInput) {
		UserResp resp = new UserResp();
		UserEntity entity = userRepository.findByName(userInput.getName());
			User user = new User();
			user.setCompnayName(entity.getDesg());
			user.setName(entity.getName());
			entity.getAddressList().stream().forEach(addEntity ->{
				AddressVO add = new AddressVO();
				add.setCity(addEntity.getCity());
				add.setState(addEntity.getState());
				add.setStreet(addEntity.getStreet());
				user.getAddList().add(add);
				
			});
			
			resp.getUserList().add(user);
		
		
		
		return resp;
	}
	
	
	public UserResp getUserByName(User userInput){
		UserResp resp = new UserResp();
		UserEntity entity = userRepository.getUserByName(userInput.getName());
			User user = new User();
			user.setCompnayName(entity.getDesg());
			user.setName(entity.getName());
			entity.getAddressList().stream().forEach(addEntity ->{
				AddressVO add = new AddressVO();
				add.setCity(addEntity.getCity());
				add.setState(addEntity.getState());
				add.setStreet(addEntity.getStreet());
				user.getAddList().add(add);
				
			});
			
			resp.getUserList().add(user);
		
		
		
		return resp;
	}
	
	
	public UserResp getUserByParam(User userInput) {
		UserResp resp = new UserResp();
		UserEntity entity = userRepository.getUserByParam(userInput.getName());
			User user = new User();
			user.setCompnayName(entity.getDesg());
			user.setName(entity.getName());
			entity.getAddressList().stream().forEach(addEntity ->{
				AddressVO add = new AddressVO();
				add.setCity(addEntity.getCity());
				add.setState(addEntity.getState());
				add.setStreet(addEntity.getStreet());
				user.getAddList().add(add);
				
			});
			
			resp.getUserList().add(user);
		
		
		
		return resp;
	}
	
	
	public UserResp getUsers(User userInput) {
		UserResp resp = new UserResp();
		List<UserEntity> list = userRepository.getUsers(userInput.getName(),
				userInput.getAddList().get(0).getState());
		list.stream().forEach(useEntity -> {
			User user = new User();
			user.setCompnayName(useEntity.getDesg());
			user.setName(useEntity.getName());
			
			
			useEntity.getAddressList().stream().forEach(addEntity ->{
				AddressVO add = new AddressVO();
				add.setCity(addEntity.getCity());
				add.setState(addEntity.getState());
				add.setStreet(addEntity.getStreet());
				user.getAddList().add(add);
				
			});
			
			resp.getUserList().add(user);
		});
		
		
		return resp;
	}
	
	
	public UserResp getUsersBySpecification(User userInput) {
		UserResp resp = new UserResp();
		
		UserSpecification spec = new UserSpecification(userInput);
		List<UserEntity> list = userRepository.findAll(spec);
		
		list.stream().forEach(useEntity -> {
			User user = new User();
			user.setCompnayName(useEntity.getDesg());
			user.setName(useEntity.getName());
			
			
			useEntity.getAddressList().stream().forEach(addEntity ->{
				AddressVO add = new AddressVO();
				add.setCity(addEntity.getCity());
				add.setState(addEntity.getState());
				add.setStreet(addEntity.getStreet());
				user.getAddList().add(add);
				
			});
			
			resp.getUserList().add(user);
		});
		
		
		return resp;
	}
}
