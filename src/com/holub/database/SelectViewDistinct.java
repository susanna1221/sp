package com.holub.database;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectViewDistinct extends ProcessDeco{
	protected String[] columns;
	public SelectViewDistinct(Table resultTable, ProcessDeco p) {
		this.resultTable = resultTable;
		this.p = p;
		columns = resultTable.getColNames();
	}
	@Override
	public void execute() {
		if(p != null) {
			p.execute();
			resultTable = p.returnResult();
		}
		else {
			Cursor current = resultTable.rows();
			int now = 0;
			int check = 0;

			while(current.advance()){
				ArrayList<String> temp = new ArrayList<String>();
				for(int i = 0 ; i < columns.length; i++) {
					temp.add(current.column(current.columnName(i)).toString());
				}
				Cursor itr = resultTable.rows();
				check = 0;
				while(now > check && itr.advance()) {
					ArrayList<String> t = new ArrayList<String>();
					for(int i = 0 ; i < columns.length; i++) {
						t.add(itr.column(itr.columnName(i)).toString());
					}
					if(Arrays.equals(t.toArray(new String[t.size()]), temp.toArray(new String[temp.size()]))) {
						current.delete();
						now--;
						break;
					}
					check++;
				}
				now++;
			}
		}
	}
	public Table returnResult() {
		return resultTable;
	}
	

}
