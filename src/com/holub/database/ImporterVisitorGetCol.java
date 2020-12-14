package com.holub.database;

import java.io.IOException;
import java.util.Iterator;

public class ImporterVisitorGetCol implements ImporterVisitor{
	public void visit(CSVImporter csvimporter) throws IOException {
		System.out.println("Get Column Names from CSV File Done!");
		System.out.printf("Column names: ");
		Iterator columns = csvimporter.loadColumnNames();
		for(int i = 0; columns.hasNext();){
			System.out.printf("%s  ", (String)columns.next());
		}
		System.out.println("");
		
	}
	
	public void visit(XMLImporter xmlimporter) throws IOException{
		System.out.println("Get Column Names from XML File Done!");
		System.out.printf("Column names: ");
		Iterator columns = xmlimporter.loadColumnNames();
		for(int i = 0; columns.hasNext();){
			System.out.printf("%s  ", (String)columns.next());
		}
		System.out.println("");
	}
}
