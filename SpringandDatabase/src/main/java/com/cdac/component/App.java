package com.cdac.component;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		//Loading Spring/IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		
		//CarPartsInventory inv = (CarPartsInventory) ctx.getBean("carParts1"); //carParts1 - id.. in CarPartsInventory me spring se iska obj banaya tha
		//CarPartsInventory inv = (CarPartsInventory) ctx.getBean("carParts2"); //for 2nd CarPArtsInventoryimpl2 ke liye hai 
		
		CarPartsInventory inv = (CarPartsInventory) ctx.getBean("carParts3");
		
		//model/entity classes are not instantiated using Spring - eseclass jisme hum filed define karte hai getter  & setter hote hai vo
		/* CarPart cp = new CarPart();
		cp.setPartName("mirror");
		cp.setCarModel("Audi");
		cp.setPrice(100);
		cp.setQuantity(25);
		
		long ms1 = System.currentTimeMillis(); //current time check
		inv.addNewPart(cp);  //method call 
		long ms2 = System.currentTimeMillis(); // method call hone ke bad ka time 
		System.out.println("Total time taken : " + (ms2 - ms1) + " ms approx"); //difference cal hoga */
		
		//agar 1st call mai jyada time lag raha hai(line 23 to 26) then 2nd time fir call karke dekho or check karo correct getbean diya hai kay line 13 coz hume 2 implemenatation use kiya hai ....
		//2nd time or kam time lagega comment reomve karke run karke dekhan..
		
		/* ms1 = System.currentTimeMillis(); //current time check
		inv.addNewPart(cp);  //method call 
	    ms2 = System.currentTimeMillis(); // method call hone ke bad ka time 
		System.out.println("Total time taken : " + (ms2 - ms1) + " ms approx"); //difference cal hoga
		 */
		
		List<CarPart> list = inv.getAvailableParts();
		for(CarPart carPart : list)
			System.out.println(carPart);
	
}
}
