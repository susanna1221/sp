/*  (c) 2004 Allen I. Holub. All rights reserved.

 *	Input format example
 *	<?xml version="1.0" encoding="UTF-8" ?> 
 *	<name>
 *	<row>
 *	<first>Fred</first><last>Flintstone</last><addrId>1</addrId>
 *	</row>
 *	<row>
 *	<first>Wilma</first><last>Flintstone</last><addrId>1</addrId>
 *	</row>
 *	<row>
 *	<first>Allen</first><last>Holub</last><addrId>0</addrId>
 *	</row>
 *	</name>
 * 
 */
package com.holub.database;

import com.holub.tools.ArrayIterator;

import java.io.*;
import java.util.*;



public class XMLImporter implements Table.Importer
{	private BufferedReader  in;			// null once end-of-file reached
	private String[]        columnNames;
	private String          tableName;
	private String			rowName;
	ArrayList<String> contents = new ArrayList<String>();

	public XMLImporter( Reader in )
	{	this.in = in instanceof BufferedReader
						? (BufferedReader)in
                        : new BufferedReader(in)
	                    ;
	}
	public void startTable()			throws IOException
	{	in.readLine();
		tableName   = in.readLine().trim().replaceAll("<", "").replaceAll(">", "");
		rowName = in.readLine().trim().replaceAll("<", "").replaceAll(">", "");
		String temp = in.readLine();
		ArrayList<String> item = new ArrayList<String>();
		
		while(temp != null) {
			if(!temp.trim().equals("</" +rowName +">") && !temp.trim().equals("<" +rowName +">")){
				contents.add(temp);
			}
			temp = in.readLine();
		}
		contents.remove(contents.size()-1);
		temp = contents.get(0);
		temp = temp.replaceAll("<", "").replaceAll(">", "<,>").replaceAll("/", ",<,>");
		for(String t : (temp.split("<,>"))) {
			if(!t.endsWith(",")) {
				item.add(t);
			}
			
		}
		
		columnNames = new String[item.size()/2];
		for(int i = 0; i<item.size()/2; i++) {
			columnNames[i] = item.get(i*2);
		}
		
	
		
	}
	public String loadTableName()		throws IOException
	{	return tableName;
	}
	public int loadWidth()			    throws IOException
	{	return columnNames.length;
	}
	public Iterator loadColumnNames()	throws IOException
	{	return new ArrayIterator(columnNames);  //{=CSVImporter.ArrayIteratorCall}
	}

	public Iterator loadRow()			throws IOException
	{	Iterator row = null;
		if( contents.size() != 0 )
		{	
			String line = contents.get(0);
			contents.remove(0);
			String n_line = "";

			for(String t : (line.replaceAll("<", "").replaceAll(">", "<,>").replaceAll("/", ",<,>").split("<,>"))) {
				if(t.endsWith(",")) {
					n_line = n_line + t;
				}
			}
			n_line = n_line.substring(0, n_line.length() - 1);
			row = new ArrayIterator( n_line.split(","));
		}
		return row;
	}

	public void endTable() throws IOException {}
	public void accept(ImporterVisitor importervisitor) {
		try {
			importervisitor.visit(this);
		} catch (IOException e) {
			System.out.println("IOException Error\n");
		}
	}
}
