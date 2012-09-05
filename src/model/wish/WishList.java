package model.wish;

import java.util.ArrayList;
import java.util.List;

import model.command.AddCommand;
import model.command.Command;
import model.command.RemoveCommand;

public class WishList {
	
	public  List<Wish> elements;
	public  String     title;
		
	public WishList() {		
		elements = new ArrayList<Wish>();
		title = "My Wish List";

	}

	public void add(Wish wish, User user) {
		Command<Wish> action = new AddCommand<Wish>();
		action.doStuff(elements, wish);
		user.keeper.add(action);
	}

	public void remove(Wish wish, User user) {
		Command<Wish> action = new RemoveCommand<Wish>();
		action.doStuff(elements, wish);
		user.keeper.add(action);
	}
	
	public int size() {
		return elements.size();
	}
	
	@Override
	public String toString(){
		String str = "";
		for (Wish w : elements) {
			str += w.toString() + ", ";
		}
		return str;
	}
	
	/**
	 * Undo should undo the last action performed in the action list
	 * @param user TODO
	 * */
	public void undo(User user) {		
		Command lastAction = (Command) user.keeper.lastCommand();
		if(lastAction == null) return;
		lastAction.undoStuff(elements);
		user.keeper.undo();
	}

	public void redo(User user) {
		Command undone = (Command) user.keeper.undoCommand();
		if(undone == null) return;
		undone.doStuff(elements, null);
		user.keeper.redo();		
	}
}
