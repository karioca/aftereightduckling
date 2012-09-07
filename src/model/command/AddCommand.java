package model.command;

import model.shopping.ShoppingList;
import model.shopping.FoodItem;


public class AddCommand implements Command {

	// receiver
	public ShoppingList list;
	public FoodItem task;
	
	public AddCommand(ShoppingList list, FoodItem task){
		this.list = list;
		this.task = task;
	}
	
	@Override
	public boolean doStuff() {
		list.add(task);
		return true;
	}

	@Override
	public void unDoStuff() {
		list.remove(task);	
	}
	
	@Override
	public String toString(){
		return "Add " + task;
	}

}
