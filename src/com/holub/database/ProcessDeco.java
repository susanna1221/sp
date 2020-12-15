package com.holub.database;

public abstract class ProcessDeco{
	protected Table resultTable;
	protected ProcessDeco p;
	
	public abstract void execute();
	public Table returnResult() {
		return resultTable;
	}
}

