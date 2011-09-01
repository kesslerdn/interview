package com.sourceallies.filter;

import java.io.PrintWriter;
import java.io.Writer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PrintWriterLogger extends PrintWriter{
	
	private Log logger = LogFactory.getLog(getClass());
	private Writer writer;

	public PrintWriterLogger(Writer writer) {
		super(writer);
		this.writer = writer;
	}

	@Override
	public void write(char[] arg0, int arg1, int arg2) {
		logger.info("response:\n" + new String(arg0));
		super.write(arg0, arg1, arg2);
	}

	public Writer getWriter() {
		return writer;
	}

	public void setLogger(Log logger) {
		this.logger = logger;
	}
}
