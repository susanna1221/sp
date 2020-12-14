package com.holub.database;

import java.io.IOException;


public class ImporterVisitorGetData implements ImporterVisitor{
	public void visit(CSVImporter csvimporter) throws IOException {
		System.out.println("Get Data from CSV File Done!");
	}
	
	public void visit(XMLImporter xmlimporter) throws IOException{
		System.out.println("Get Data from XML File Done!");
	}
		
}
