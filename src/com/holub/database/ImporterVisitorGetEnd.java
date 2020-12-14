package com.holub.database;

import java.io.IOException;

public class ImporterVisitorGetEnd implements ImporterVisitor{
	public void visit(CSVImporter csvimporter) throws IOException {
		System.out.println("END. Importing CSV file Done\n");
	}
	
	public void visit(XMLImporter xmlimporter) throws IOException{
		System.out.println("END. Importing XML file Done\n");
	}

}
