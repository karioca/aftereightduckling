package model.command;

import model.shopping.ShoppingList;
import model.shopping.FoodItem;


public class AddCommand implements Command {

	public ShoppingList list;
	public FoodItem item;
	
	public AddCommand(ShoppingList list, FoodItem item){
		this.list = list;
		this.item = item;
	}
	
	@Override
	public boolean doStuff() {
		list.add(item);
		return true;
	}

	@Override
	public void unDoStuff() {
		list.remove(item);	
	}
	
	@Override
	public String toString(){
		return "Add " + item;
	}

}
