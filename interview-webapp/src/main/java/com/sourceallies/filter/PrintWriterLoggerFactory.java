package com.sourceallies.filter;

import java.io.Writer;

public class PrintWriterLoggerFactory {

	public PrintWriterLogger create(Writer writer) {
		return new PrintWriterLogger(writer);
	}

}
