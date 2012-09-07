package model.command;

import java.util.List;

public class OldAddCommand<T> implements OldCommand<T> {

	protected String actionType;
	protected T memento;
	
	public OldAddCommand() {
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
