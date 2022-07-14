package com.cdac.service;

public class LoginService {
	public boolean loginCheck(String username, String password) {
		if(username.equals(password))
			return true;
		return false;
	}
}
