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
		BufferedReader br = null;
		File location = new File("C:\\dp2020");
		File addr = new File(location, "address.csv");
		File name = new File(location, "name.csv");
		Path path = addr.getAbsoluteFile().toPath();
		br = Files.newBufferedReader(path);
		Table t1 = new TableFactory().create(new CSVImporter(br));
		path = name.getAbsoluteFile().toPath();
		br = Files.newBufferedReader(path);
		Table t2 = new TableFactory().create(new CSVImporter(br));
		
		Writer out = new FileWriter(new File(location, "address" + ".html"));
		t1.export( new HTMLExporter(out) );
		out = new FileWriter(new File(location, "name" + ".html"));
		t2.export( new HTMLExporter(out) );
		out.close();
		

	}

}
