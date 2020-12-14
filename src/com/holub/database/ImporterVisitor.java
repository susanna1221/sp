package com.holub.database;

import java.io.IOException;

public interface ImporterVisitor {
	void visit(CSVImporter csvimporter) throws IOException;
	void visit(XMLImporter xmlimporter) throws IOException;

}
