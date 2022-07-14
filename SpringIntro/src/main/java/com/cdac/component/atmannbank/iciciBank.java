package com.cdac.component.atmannbank;
import org.springframework.stereotype.Component;

@Component("iciciBank-v2")
public class iciciBank implements Bank {
	public boolean isAccountPresent(int acno) {
		if(acno == 20202020)
			return true;
		else
			
		return false;
	}
	public void withdraw(int atmId, int acno, double amount) {
		System.out.println("Customer of iciciBank wants to withdraw money..");
	}
}
