package model.command;

import model.shopping.FoodItem;
import model.shopping.ShoppingList;

public class RemoveCommand implements Command {

	public ShoppingList list;
	public FoodItem task;
	
	public RemoveCommand(ShoppingList list, FoodItem task) {
		this.list = list;
		this.task = task;
	}
	@Override
	public boolean doStuff() {
		if(!list.tasks.contains(task))
			return false;
		list.remove(task);
		return true;
	}

	@Override
	public void unDoStuff() {
		list.add(task);
	}
	
	@Override
	public String toString() {
		return "Remove " + task;
	}
}
