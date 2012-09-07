package test.shopping;

import model.command.AddCommand;
import model.command.Command;
import model.shopping.MagicButton;
import model.shopping.RemoveCommand;
import model.shopping.ShoppingList;
import model.shopping.FoodItem;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class ShoppingListTest {
	FoodItem[] foods = new FoodItem[]{ new FoodItem("Granola"), new FoodItem("Milk"), new FoodItem("Cheese"), new FoodItem("Fish") };
	FoodItem[] fruits = new FoodItem[]{ new FoodItem("Apple"), new FoodItem("Banana"), new FoodItem("Coconut"), new FoodItem("Dewberry") };
	
	@Test
	public void testCreateAndAddToTodoList(){
		
		ShoppingList list = getList(foods);
		assertThat(list.tasks.size(), is(not(0)));
		assertThat(list.tasks.size(), is(4));
	}
	
	@Test
	public void testRemoveFromTodoList(){
		ShoppingList list = getList(foods);
		System.out.println(list);
		int size = list.tasks.size();
				
		FoodItem task1 = list.tasks.get(1);
		System.out.println(task1);
		
		list.remove(task1);
		System.out.println(list);
		assertThat(list.tasks.size(), is(size - 1));
	}
	
	@Test
	public void testUndoAdd(){
		ShoppingList list = getList(foods);
		System.out.println(list);
		
		FoodItem task1 = new FoodItem("Have breakfast");
		Command add = new AddCommand(list, task1);
		add.doStuff();
		System.out.println(list);
		add.doStuff();
		System.out.println(list);
		add.unDoStuff();
		System.out.println(list);
		add.unDoStuff();
		System.out.println(list);
		add.unDoStuff();
		System.out.println(list);
		add.unDoStuff();
		System.out.println(list);
		add.unDoStuff();
		System.out.println(list);
	}
	
	@Test
	public void testHistory(){
		ShoppingList list = getList(fruits);
		System.out.println("List: " + list);
		int size = list.tasks.size();
		
		FoodItem task1 = new FoodItem("Fig");
		
		MagicButton button = new MagicButton();
		Command add = new AddCommand(list, task1);
		
		button.doIt(add);
		button.doIt(add);
		button.doIt(add);
		button.doIt(add);
		
		assertThat(list.tasks.size(), is(size + 4));
		
		System.out.println("List: " + list);
		System.out.println("History: " + button);	

		button.undoIt();
		button.undoIt();
		assertThat(list.tasks.size(), is(size + 2));
		
		System.out.println("List: " + list);
		System.out.println("History: " + button);	
		
		FoodItem task2 = list.tasks.get(1);
		
		Command remove = new RemoveCommand(list, task2);
		button.doIt(remove);
		button.doIt(remove);
		button.doIt(remove);
		button.doIt(remove);
		assertThat(list.tasks.size(), is(size + 1));
		
		System.out.println("List: " + list);
		System.out.println("History: " + button);	
		
		button.undoIt();
		button.undoIt();
		button.undoIt();
		button.undoIt();
		assertThat(list.tasks.size(), is(size));
		
		System.out.println("List: " + list);
		System.out.println("History: " + button);		
	}

	private ShoppingList getList(FoodItem[] l) {
		ShoppingList list = new ShoppingList();		
		for(FoodItem t : l){
			list.add(t);
		}
		return list;
	}

}

