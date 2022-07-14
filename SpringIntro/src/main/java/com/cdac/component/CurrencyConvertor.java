package com.cdac.component;

import org.springframework.stereotype.Component;


@Component("currencyConv") //alternative to <bean id="currencyConv" class="com.cdac.component.CurrencyConverter" />
public class CurrencyConvertor {
	
public double convert(String from ,String to, double amount) {
		if(from.equals("usd") && to.equals("INR"))
			return 78.98 * amount;
		else if(from.equals("GBP") && to.equals("INR"))
			return 94.41 * amount;
		else
			return 0; //ye likhe ki bajay rather we should throw exception 
			//throw new CurrencyConverterException("Conversion of given currency not supported!");
		
	}

}
