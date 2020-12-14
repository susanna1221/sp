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
		File objectfile_addr = new File(location, "address.csv");
		Path path_addr = objectfile_addr.getAbsoluteFile().toPath();
	
		//IMP address.csv -> EXP address.xml -> IMP address.xml -> EXP address.html
		BufferedReader br = null;
		br = Files.newBufferedReader(path_addr);
		Table t_csv_addr = new TableFactory().create(new CSVImporter(br));
		br.close();
	
		Writer out = new FileWriter(new File(location, "address.xml"));
		t_csv_addr.export( new XMLExporter(out) );
		out.close();
		
		
	}
			
}
