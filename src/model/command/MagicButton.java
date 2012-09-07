package model.command;

import java.util.ArrayList;
import java.util.List;


public class MagicButton {
	
	private List<Command> history;
	
	public MagicButton(){
		history = new ArrayList<Command>();
	}
	
	public void doIt(Command cmd){
		if(cmd.doStuff()){
			history.add(cmd);
		}
	}
	
	public void undoIt(){
		int s = history.size();
		if(s >= 1){
			Command cmd = history.get(s - 1);
			cmd.unDoStuff();
			history.remove(cmd);
		}
	}
	
	@Override
	public String toString(){
		String s = "";
		for(Command c : history){
			s += c + ", ";
		}
		return s;
	}
}
