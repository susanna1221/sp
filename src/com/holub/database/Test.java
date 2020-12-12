package com.holub.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Test {

	public static void main(String[] args) throws IOException {
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		File location = new File("C:\\dp2020");
		
		File addr = new File(location, "address.csv");
		File name = new File(location, "name.csv");
		
		//Import address.csv
		Path path_add = addr.getAbsoluteFile().toPath();
		br1 = Files.newBufferedReader(path_add);
		Table t1 = new TableFactory().create(new CSVImporter(br1));
		
		//Import name.csv
		Path path_name = name.getAbsoluteFile().toPath();
		br2 = Files.newBufferedReader(path_name);
		Table t2 = new TableFactory().create(new CSVImporter(br2));
		
		/*HTML Exporter Test*/
		
		//Export address.html
		Writer out1 = new FileWriter(new File(location, "address" + ".html"));
		t1.export( new HTMLExporter(out1) );
		out1.close();
		
		//Export name.html
		Writer out2 = new FileWriter(new File(location, "name" + ".html"));
		t2.export( new HTMLExporter(out2) );
		out2.close();
		
		/*XML Exporter Test*/
		
		//Export address.xml
		out1 = new FileWriter(new File(location, "address" + ".xml"));
		t1.export( new XMLExporter(out1) );
		out1.close();
		
		//Export name.xml
		out2 = new FileWriter(new File(location, "name" + ".xml"));
		t2.export( new XMLExporter(out2) );
		out2.close();
		
		

	}

}
