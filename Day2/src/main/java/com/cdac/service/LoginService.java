package com.cdac.service;

public class LoginService {
	public boolean loginCheck(String username, String password) {   //logincheck is   method
		if(username.equals("yoga") && password.equals("123"))
			return true;
		return false;
	}

}
