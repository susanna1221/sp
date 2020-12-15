package com.holub.database;

public class ExporterVisitorStoreRow implements ExporterVisitor{
	public void visit(CSVExporter csvexporter) {
		System.out.println("Store Row Data Done!(CSV)");
	}
	public void visit(HTMLExporter htmlexporter) {
		System.out.println("Store Row Data Done!(HTML)");
	}
	public void visit(XMLExporter xmlexporter) {
		System.out.println("Store Row Data Done!(XML)");
	}
	public void visit(JTableExporter jtableexporter) {
		System.out.println("Store Row Data Done!(JTable)");
	}


}
