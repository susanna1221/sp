package com.holub.database;

public class ExporterVisitorEnd implements ExporterVisitor{
	public void visit(CSVExporter csvexporter) {
		System.out.println("END. Exporting to CSV File Done\n");
	}
	public void visit(HTMLExporter htmlexporter) {
		System.out.println("END. Exporting to HTML File Done\n");
	}
	public void visit(XMLExporter xmlexporter) {
		System.out.println("END. Exporting to XML File Done\n");
	}
	public void visit(JTableExporter jtableexporter) {
		System.out.println("END. Exporting to JTable File Done\n");
	}

}
