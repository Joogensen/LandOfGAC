package edu.gac.mcs178.gack.domain;

import java.util.ArrayList;

import java.util.List;

import edu.gac.mcs178.gack.Utility;

public class Food extends Thing {
	
	public Food(String title) {
		super(title);
	}

	public void beEaten() {
		Person owner = getOwner();
		if (owner == null) {
			Utility.displayMessage("No one has " + getName());
		} else {
			owner.say("I have eaten " + getName());
			
		}
	}
	
	public static List<Food> foodIn(Place place) {
		ArrayList<Food> foodIn = new ArrayList<Food>();
		for (Thing thing : place.getContents()) {
			if (thing instanceof Food) {
				foodIn.add((Food) thing);
			}
		}
		return foodIn;
	}
	
	
	
}
