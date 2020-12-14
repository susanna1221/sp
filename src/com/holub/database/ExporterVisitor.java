package com.holub.database;

public interface ExporterVisitor {
	void visit(CSVExporter csvexporter);
	void visit(HTMLExporter htmlexporter);
	void visit(XMLExporter xmlexporter);
	void visit(JTableExporter jtableexporter);

}
