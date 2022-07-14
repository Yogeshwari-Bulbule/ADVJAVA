package com.cdac.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.component.Atm;
import com.cdac.component.Calculator;
import com.cdac.component.Car;
import com.cdac.component.CurrencyConvertor;
import com.cdac.component.HelloWorld;
import com.cdac.component.LoginService;
import com.cdac.component.TextEditer;

public class App {

	public static void main(String[] args) {
		
		//Loading Spring/IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml"); 
		//Accessing a particular bean
				HelloWorld hw = (HelloWorld) ctx.getBean("hello"); //hello is id which is define in xml file in bean tag
				System.out.println(hw.sayHello("Yogeshwari"));		
				//But why are we using Spring to create object of HelloWorld class?
						//We could have created object on our own like this:
						//HelloWorld hw = new HelloWorld();
				
				Calculator c = ctx.getBean("calc", Calculator.class); 
			//	Calculator c = (Calculator) ctx.getBean("calc"); ise bhi likh sakte hai upper wali line
				System.out.println(c.add(10, 20));
				System.out.println(c.sub(10, 20));
				
				CurrencyConvertor cc = (CurrencyConvertor) ctx.getBean("currencyConv");
				System.out.println(cc.convert("USD", "INR", 650));
				
				LoginService loginServ =(LoginService) ctx.getBean("loginServ");
				System.out.println(loginServ.isValidUser("yogeshwari", "456"));
				
				//TextEditor te = (TextEditor) ctx.getBean("txtEdtr");
				TextEditer te = (TextEditer) ctx.getBean("txtEdtr");
				te.load("abc.txt");
				
				Car car = (Car) ctx.getBean("car");
				car.drive();
				
				Atm atm = (Atm) ctx.getBean("hdfcAtm");
				atm.withdraw(101010, 5000);
	}

}


/* note - ye wale class mai hum @autowired use nahi kar sakte ye class jvm load kar raha hai (main method) pahile bad main spring load 
 * ho rahi hai
 */
           