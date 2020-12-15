package com.holub.database;

public class SelectViewDistinct extends SelectViewProcess{
	protected String[] columns;
	public SelectViewDistinct(SelectViewProcess svp) {
		this.svp = svp;
		this.resultTable = svp.returnResult();
		//columns = resultTable.
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	public Table returnResult() {
		return resultTable;
	}
	

}
