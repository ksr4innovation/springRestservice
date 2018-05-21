package com.snkit.springboottest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity implements Serializable {

	
	public UserEntity() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userid;
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="desg")
	private String desg;


	@OneToMany(mappedBy="userEntity",fetch=FetchType.LAZY,cascade=CascadeType.ALL)	
	private List<AddressEntity> addressList = new ArrayList<AddressEntity>();


	public long getUserid() {
		return userid;
	}


	public void setUserid(long userid) {
		this.userid = userid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDesg() {
		return desg;
	}


	public void setDesg(String desg) {
		this.desg = desg;
	}


	public List<AddressEntity> getAddressList() {
		return addressList;
	}


	public void setAddressList(List<AddressEntity> addressList) {
		this.addressList = addressList;
	}
	
	
	
	
}
