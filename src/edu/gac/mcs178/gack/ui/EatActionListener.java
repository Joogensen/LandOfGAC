package edu.gac.mcs178.gack.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;

import edu.gac.mcs178.gack.domain.Food;
import edu.gac.mcs178.gack.domain.Person;
//import edu.gac.mcs178.gack.domain.Scroll;

public class EatActionListener implements ActionListener {
	
	private static final Food INTSRUCTIONS = new Food("Eat ...");
	
	private GraphicalUserInterface gui;
	private Person player;
	private JComboBox eatJComboBox;
	private boolean enabled;
	private List<Food> foods;

	public EatActionListener(GraphicalUserInterface gui, Person player, JComboBox eatJComboBox) {
		super();
		this.gui = gui;
		this.player = player;
		this.eatJComboBox = eatJComboBox;
		this.enabled = true;
		foods = Food.foodIn(player.getPlace());
		eatJComboBox.addItem(INTSRUCTIONS);
		for (Food food : foods) {
			eatJComboBox.addItem(foods);
		}
	}
				
	public void setEnabled(boolean b) {
		enabled = b;
	}
	
	
	public void updateJComboBox() {
		eatJComboBox.removeAllItems();
		foods = Food.foodIn(player.getPlace());
		eatJComboBox.addItem(INTSRUCTIONS);
		for (Food food : foods) {
			eatJComboBox.addItem(food);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (enabled) {
			Food item = (Food) eatJComboBox.getSelectedItem();
			if (!item.getName().equals(INTSRUCTIONS.getName())) {
				gui.displayMessage("\n>>> Eat " + item);
				player.lose(item);
				gui.playTurn();
			}
		}
	}
}
