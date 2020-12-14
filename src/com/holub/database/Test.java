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
		
		
		//And some more tests for Exporter, Importer
		
		File location = new File("C:\\dp2020");
		File objectfile_addr = new File(location, "address.csv");
		File objectfile_name= new File(location, "name.csv");
		Path path_addr = objectfile_addr.getAbsoluteFile().toPath();
		Path path_name = objectfile_name.getAbsoluteFile().toPath();
		
		/*CSV Importer*/
		//address
		BufferedReader br = null;
		br = Files.newBufferedReader(path_addr);
		Table t_csv_addr = new TableFactory().create(new CSVImporter(br));
		br.close();
		//name
		br = Files.newBufferedReader(path_name);
		Table t_csv_name = new TableFactory().create(new CSVImporter(br));
		br.close();
		
		/*HTML Exporter*/
		//address
		Writer out = new FileWriter(new File(location, "address.html"));
		t_csv_addr.export( new HTMLExporter(out) );
		out.close();
		//name
		out = new FileWriter(new File(location, "name.html"));
		t_csv_name.export( new HTMLExporter(out) );
		out.close();
		
		/*XML Exporter*/
		//address
		out = new FileWriter(new File(location, "address.xml"));
		t_csv_addr.export( new XMLExporter(out) );
		out.close();
		//name
		out = new FileWriter(new File(location, "name.xml"));
		t_csv_name.export( new XMLExporter(out) );
		out.close();
		
		
		
		File objectfile_addr_xml = new File(location, "address.xml");
		File objectfile_name_xml= new File(location, "name.xml");
		Path path_addr_xml = objectfile_addr_xml.getAbsoluteFile().toPath();
		Path path_name_xml = objectfile_name_xml.getAbsoluteFile().toPath();
		
		/*XML Importer*/
		//address
		br = Files.newBufferedReader(path_addr_xml);
		Table t_addr_xml = new TableFactory().create(new XMLImporter(br));
		br.close();
		//name
		br = Files.newBufferedReader(path_name_xml);
		Table t_name_xml = new TableFactory().create(new XMLImporter(br));
		br.close();
		
		assertEquals(t_csv_name.toString(), t_name_xml.toString());
		
		
		/*CSV Exporter(XML -> CSV)*/
		//address
		out = new FileWriter(new File(location, "address_from_xml.csv"));
		t_addr_xml.export( new CSVExporter(out) );
		out.close();
		//name
		out = new FileWriter(new File(location, "name_from_xml.csv"));
		t_name_xml.export( new CSVExporter(out) );
		out.close();
	

	}

}
