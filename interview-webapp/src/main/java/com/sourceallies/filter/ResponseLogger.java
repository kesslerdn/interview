package com.sourceallies.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ResponseLogger extends HttpServletResponseWrapper {
	
	PrintWriterLoggerFactory printWriterLoggerFactory = new PrintWriterLoggerFactory();

	public ResponseLogger(HttpServletResponse response) {
		super(response);
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		PrintWriter writer = super.getWriter();
		return printWriterLoggerFactory.create(writer);
	}

	public void setPrintWriterLoggerFactory(
			PrintWriterLoggerFactory printWriterLoggerFactory) {
		this.printWriterLoggerFactory = printWriterLoggerFactory;
	}
}
