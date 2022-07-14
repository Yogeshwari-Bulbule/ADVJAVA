package com.cdac.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("txtEdtr")
public class TextEditer {

	@Autowired //DI(dependencies injection)
	private SpellChecker sp; //using this spring create this obj 
	
	public void load(String document) {
		System.out.println("some code here for loading " + document);
		//from here we want to invoke the spell checker
		//SpellChecker sp = new SpellChecker();  creating obj using new keyword
		//but we want Spring to create the required object for us hence used @Autowired
		sp.checkSpellingMistakes(document);
	}
}


//Note - spring se obj karna hai to 1)bean tag 2) @component
// @autowired se ek  class ka obj dusare class access karne ke liye(to get obj of particular class) replacement of getbean 