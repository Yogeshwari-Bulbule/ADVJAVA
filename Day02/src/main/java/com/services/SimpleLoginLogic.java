package com.services;

public class SimpleLoginLogic {
	public boolean test(String username, String password) {
		if (username.equals(password)) {
			return true;
		}
		return false;
	}
}
