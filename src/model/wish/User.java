package model.wish;

import model.command.CommandKeeper;

public class User {

	public String name;
	public CommandKeeper keeper;

	
	public User(String name){
		keeper = new CommandKeeper();
		this.name = name;
	}
	
	public void name(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( this == obj ) return true;
		if ( !(obj instanceof User) ) return false;
		User that = (User)obj;
		  
		return (keeper.id == that.keeper.id) &&
				name.equals(that.name);
	}
	
	@Override
	public String toString(){
		return name + " " + keeper;
	}

}
