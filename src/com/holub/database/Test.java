package com.holub.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;






public class Test {
	public static void main(String[] args) throws IOException {
		TestImpExp a = new TestImpExp();
		
		//Create address concrete table with CSV
		a.createConcreteTablewithCSV();
		//Export as HTML
		a.createOutputFilewithHTML();
		//Export as XML
		a.createOutputFilewithXML();
		//Import with XMLImporter
		a.createConcreteTablewithXML();
		
		assertEquals(a.resultTable_csv.toString(), a.resultTable_xml.toString());
		
	

	}

}
