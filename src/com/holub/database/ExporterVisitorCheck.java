package com.holub.database;

public class ExporterVisitorCheck implements ExporterVisitor{
	public void visit(CSVExporter csvexporter) {
		System.out.println("Exporting to CSV File");
	}
	public void visit(HTMLExporter htmlexporter) {
		System.out.println("Exporting to HTML File");
	}
	public void visit(XMLExporter xmlexporter) {
		System.out.println("Exporting to XML File");
	}
	public void visit(JTableExporter jtableexporter) {
		System.out.println("Exporting to JTable File");
	}

}
