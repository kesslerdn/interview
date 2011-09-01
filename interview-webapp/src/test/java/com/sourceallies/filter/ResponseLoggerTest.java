package com.sourceallies.filter;

import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletResponse;


public class ResponseLoggerTest {
	
	@Test
	public void testGetWriter() throws Exception{
		HttpServletResponse mockResponse = new MockHttpServletResponse();
		ResponseLogger responseLogger = new ResponseLogger(mockResponse);
		PrintWriterLoggerFactory mockFactory = mock(PrintWriterLoggerFactory.class);
		PrintWriterLogger mockPrintWriterLogger = mock(PrintWriterLogger.class);
		
		when(mockFactory.create(isA(PrintWriter.class))).thenReturn(mockPrintWriterLogger);
		
		responseLogger.setPrintWriterLoggerFactory(mockFactory);
		
		PrintWriter writer = responseLogger.getWriter();
		
		assertSame(mockPrintWriterLogger, writer);
	}
}
