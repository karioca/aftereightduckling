package model.shopping;

public class FoodItem {
	public String title;
	public FoodItem(String title) {
		this.title = title;		
	}
	
	@Override
	public String toString(){
		return title;
	}
}
