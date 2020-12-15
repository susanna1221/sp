package com.holub.database;

public class ExporterVisitorStoreMeta implements ExporterVisitor{
	public void visit(CSVExporter csvexporter) {
		System.out.println("Store MetaData Done!(CSV)");
	}
	public void visit(HTMLExporter htmlexporter) {
		System.out.println("Store MetaData Done!(HTML)");
	}
	public void visit(XMLExporter xmlexporter) {
		System.out.println("Store MetaData Done!(XML)");
	}
	public void visit(JTableExporter jtableexporter) {
		System.out.println("Store MetaData Done!(JTable)");
	}

}
