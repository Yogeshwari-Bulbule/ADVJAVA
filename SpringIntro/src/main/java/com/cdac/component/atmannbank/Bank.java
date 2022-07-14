package com.cdac.component.atmannbank;

public interface Bank {

	 public boolean isAccountPresent(int acno);
	public void withdraw(int atmId, int acno, double amount);
}
