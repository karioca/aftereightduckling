package model.command;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class CommandKeeper<T, where extends Command> {
	public int id;
	public List<T> commands;
	public T undoneAction;
	

	public CommandKeeper() {
		id = makeID();
		commands = new ArrayList<T>();
	}
	
	public void add(T newT){		
		commands.add(newT);
	}
	
	@Override
	public String toString(){
		String str = "";
		for (T w : commands) {
			str += w.toString() + ", ";
		}
		return str;
	}

	public void undo() {
		T lastAction = lastCommand();		
		commands.remove(lastAction);
		undoneAction = lastAction;
	}
	
	public T lastCommand() {
		if(commands.size() < 1) return null;
		return commands.get(commands.size()-1);
	}
	
	public T undoCommand(){
		return undoneAction;
	}
	
	public void redo() {
		if(undoneAction == null) return;
		commands.add(undoneAction);
		undoneAction = null;
	}
	
	private int makeID() {
		Calendar cal = Calendar.getInstance();
		long time = cal.getTimeInMillis();
		
		return (int) Math.ceil((time * 13));
	}
	
}