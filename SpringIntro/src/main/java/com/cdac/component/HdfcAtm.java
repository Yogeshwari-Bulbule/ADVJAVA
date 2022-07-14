package com.cdac.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component  //here after @component if not write id then here id is consider as a class name
//@Component("hdfcAtm"); 
public class HdfcAtm implements Atm {

	@Autowired
	private Bank bank;
	
	public void withdraw(int acno, double amount) {
		System.out.println("Customer at HdfcAtm wants to withdraw money..");
		bank.withdraw(12345, acno, amount);
	}

}
