package com.kinetix.sandbox.java.sets;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Study {

	private Set<String> flavors = new TreeSet();
	
	Study(){
		
	}
	
	void setFlavorCollection(Set<String> flavors){
		this.flavors.addAll(flavors);
	}
	
	void displayFlavors(){
		Iterator<String> iter = flavors.iterator();
		while(iter.hasNext()){
			String cream = (String)iter.next();
			System.out.println("Flavor: "+cream);
		}
	}
}
