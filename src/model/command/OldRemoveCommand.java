package model.command;

import java.util.List;

public class OldRemoveCommand<T> implements OldCommand<T> {
	
	protected String actionType;
	protected T memento;

	public OldRemoveCommand() {
		actionType = "Remove";
	}
	

	@Override
	public void doStuff(List<T> list, T newT) {
		memento = newT;
		list.remove(memento);
	}

	@Override
	public void undoStuff(List<T> list) {
		list.add(memento);
	}

	@Override
	public String toString() {
		return actionType;
	}
}
