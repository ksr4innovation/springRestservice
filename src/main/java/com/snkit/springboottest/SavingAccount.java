package com.snkit.springboottest;

import org.springframework.stereotype.Service;

@Service
public class SavingAccount implements Account {

	@Override
	public void accountDetails() {
		System.out.println("  From saving accountDetails");

	}

}
