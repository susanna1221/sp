package com.holub.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestforVisitor {
	public static void main(String[] args) throws IOException {
		File location = new File("C:\\dp2020");
		File objectfile_addr_csv = new File(location, "address.csv");
		Path path_addr_csv = objectfile_addr_csv.getAbsoluteFile().toPath();
		File objectfile_addr_xml = new File(location, "address.xml");
		Path path_addr_xml = objectfile_addr_xml.getAbsoluteFile().toPath();
	
		//IMP address.csv -> EXP address.xml -> IMP address.xml -> EXP address.html
		BufferedReader br = null;
		br = Files.newBufferedReader(path_addr_csv);
		Table t_csv_addr_csv = new TableFactory().create(new CSVImporter(br));
		br.close();
	
		Writer out = new FileWriter(new File(location, "address.xml"));
		t_csv_addr_csv.export( new XMLExporter(out) );
		out.close();
		
		br = Files.newBufferedReader(path_addr_xml);
		Table t_csv_addr_xml = new TableFactory().create(new XMLImporter(br));
		br.close();
		
		out = new FileWriter(new File(location, "address.html"));
		t_csv_addr_xml.export( new HTMLExporter(out) );
		out.close();
	}
			
}
