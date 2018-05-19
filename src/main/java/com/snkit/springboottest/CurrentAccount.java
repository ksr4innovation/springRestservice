package com.snkit.springboottest;

import org.springframework.stereotype.Service;

@Service
public class CurrentAccount implements Account {

	@Override
	public void accountDetails() {
		System.out.println("  From Current Account details");

	}

}
