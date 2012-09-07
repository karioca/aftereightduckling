package model.wish;

import java.util.ArrayList;
import java.util.List;

import model.command.OldAddCommand;
import model.command.OldCommand;
import model.command.OldRemoveCommand;

public class WishList {
	
	public  List<Wish> elements;
	public  String     title;
		
	public WishList() {		
		elements = new ArrayList<Wish>();
		title = "My Wish List";

	}

	public void add(Wish wish, User user) {
		OldCommand<Wish> action = new OldAddCommand<Wish>();
		action.doStuff(elements, wish);
		user.keeper.add(action);
	}

	public void remove(Wish wish, User user) {
		OldCommand<Wish> action = new OldRemoveCommand<Wish>();
		action.doStuff(elements, wish);
		user.keeper.add(action);
	}
	
    public void undo(User user) {		
		OldCommand lastAction = (OldCommand) user.keeper.lastCommand();
		if(lastAction == null) return;
		lastAction.undoStuff(elements);
		user.keeper.undo();
	}

	public void redo(User user) {
		OldCommand undone = (OldCommand) user.keeper.undoCommand();
		if(undone == null) return;
		undone.doStuff(elements, null);
		user.keeper.redo();		
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
}
