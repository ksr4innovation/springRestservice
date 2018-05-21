package com.snkit.springboottest;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String name;
	private String compnayName;
	
	private List<AddressVO> addList = new ArrayList<AddressVO>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<AddressVO> getAddList() {
		return addList;
	}
	public void setAddList(List<AddressVO> addList) {
		this.addList = addList;
	}
	public String getCompnayName() {
		return compnayName;
	}
	public void setCompnayName(String compnayName) {
		this.compnayName = compnayName;
	}
	
	

}
