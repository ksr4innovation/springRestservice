package com.snkit.springboottest;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_add")
public class AddressEntity implements Serializable {

	public long getAddressid() {
		return addressid;
	}

	public void setAddressid(long addressid) {
		this.addressid = addressid;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = -5704816610806627334L;
	
	
	public AddressEntity() {
		
	}// Default constructor for JPA

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long addressid;
	
	@Column(name="city")
	private String city;
	
	
	@Column(name="street")
	private String street;
	
	@Column(name="state")
	private String state;


	@Column(name="userid",nullable=false,updatable=false)
	private long userid;

	@ManyToOne
	private UserEntity userEntity;
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	
	
	
}
