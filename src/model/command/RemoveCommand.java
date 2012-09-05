package model.command;

import java.util.List;

public class RemoveCommand<T> implements Command<T> {
	
	protected String actionType;
	protected T memento;

	public RemoveCommand() {
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
