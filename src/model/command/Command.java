package model.command;

import java.util.List;


public interface Command<T> {

	public abstract void   doStuff(List<T> list, T newT);

	public abstract void   undoStuff(List<T> list);

	public abstract String toString();

}