package model.command;

import java.util.List;

public class AddCommand<T> implements Command<T> {

	protected String actionType;
	protected T memento;
	
	public AddCommand() {
		actionType = "Add";
	}

	@Override
	public void doStuff(List<T> list, T newT) {
		if(newT != null) 
			memento = newT;
		list.add(memento);
	}

	@Override
	public void undoStuff(List<T> list){
		list.remove(memento);
	}
	
	@Override
	public String toString() {
		return actionType;
	}

}
