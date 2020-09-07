package com.kinetix.sets;

import java.util.Set;
import java.util.TreeSet;

public class SetHandling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SetHandling test = new SetHandling();
		test.firetest();

	}
	
	SetHandling(){
	
	}
	
	public void firetest(){
		Set<String> series = new TreeSet<String>();
		
		series.add("Fudge");
		series.add("Vanilla");
		series.add("Chocolate");
		series.add("Strawberry");
		
		Study study = new Study();
		study.setFlavorCollection(series);
		study.displayFlavors();
		series.clear();
		study.displayFlavors();
		
		System.out.println("Print out Series collection: "+series.toString());
		
		study.displayFlavors();

	}

}
