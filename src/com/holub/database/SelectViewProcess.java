package com.holub.database;

public abstract class SelectViewProcess {
	protected Table resultTable;
	protected SelectViewProcess svp;
	public abstract void execute();
	public Table returnResult() {
		return resultTable;
	}
}
