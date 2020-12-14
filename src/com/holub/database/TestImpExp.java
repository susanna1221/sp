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
import org.junit.Test;




public class TestImpExp {
	File location = new File("C:\\dp2020");
	File objectfile_csv = new File(location, "address.csv");
	File objectfile_xml= new File(location, "address.xml");
	Path path_csv = objectfile_csv.getAbsoluteFile().toPath();
	Path path_xml = objectfile_xml.getAbsoluteFile().toPath();
	String[] temp = {"a", "b", "c"};
	public Table resultTable_csv = new ConcreteTable("temp", temp);
	public Table resultTable_xml = new ConcreteTable("temp", temp);
	
	
	
	@Test
	//Test CSVImporter
	public void createConcreteTablewithCSV() throws IOException {
		BufferedReader br = null;
		br = Files.newBufferedReader(path_csv);
		resultTable_csv = new TableFactory().create(new CSVImporter(br));
		br.close();
	}
	
	@Test
	//Test XMLImporter
	public void createConcreteTablewithXML() throws IOException {
		BufferedReader br = null;
		br = Files.newBufferedReader(path_xml);
		resultTable_xml = new TableFactory().create(new XMLImporter(br));
		br.close();
	}
	
	@Test
	//Test HTMLExporter
	public void createOutputFilewithHTML() throws IOException {
		createConcreteTablewithCSV();
		Writer out = new FileWriter(new File(location, "address_new.html"));
		resultTable_csv.export( new HTMLExporter(out) );
		out.close();	
	}
	
	@Test
	//Test XMLExporter
	public void createOutputFilewithXML() throws IOException {
		createConcreteTablewithCSV();
		Writer out = new FileWriter(new File(location, "address_new.xml"));
		resultTable_csv.export( new XMLExporter(out) );
		out.close();	
	}
	

}
