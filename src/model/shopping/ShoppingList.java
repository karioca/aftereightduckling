package model.shopping;

import java.util.ArrayList;
import java.util.List;



// receiver class
public class ShoppingList {
	public List<FoodItem> tasks = new ArrayList<FoodItem>(); 
	
	public void add(FoodItem task){
		tasks.add(task);
	}
	
	public void remove(FoodItem task){
		tasks.remove(task);
	}
	
	@Override
	public String toString(){
		String str = "";
		for(FoodItem t : tasks){
			str += t + ", ";
		}
		return str;		
	}
}
