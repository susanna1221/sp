package com.holub.database;

import java.io.IOException;

public class ImporterVisitorCheck implements ImporterVisitor{
	public void visit(CSVImporter csvimporter) throws IOException {
		System.out.println("Importing CSV File");
		System.out.printf("Table name: %s\n",csvimporter.loadTableName());
	}
	public void visit(XMLImporter xmlimporter) throws IOException{
		System.out.println("Importing XML File");
		System.out.printf("Table name: %s\n",xmlimporter.loadTableName());
	}

}
