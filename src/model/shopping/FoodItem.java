package model.shopping;

public class FoodItem {
	public String name;
	public FoodItem(String name) {
		this.name = name;		
	}
	
	@Override
	public String toString(){
		return name;
	}
}
