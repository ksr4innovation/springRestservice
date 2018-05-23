package com.snkit.springboottest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	public UserEntity findByName(String name);	
	
	@Query("select ue from UserEntity ue where ue.name=?1")
	public UserEntity getUserByName(String name );
	
	@Query("select ue from UserEntity ue where ue.name =:inputName")
	public UserEntity getUserByParam(@Param("inputName") String inputName);
	
	
	@Query("select ue from UserEntity ue "
			+" inner join ue.addressList al "
			+ "where ue.name =:inputName and al.state = :inputState")
	public List<UserEntity> getUsers(@Param("inputName") String inputName,
				@Param("inputState") String inputState);
	
	
	
	
	
	
	
	
	
	
	
	

}
