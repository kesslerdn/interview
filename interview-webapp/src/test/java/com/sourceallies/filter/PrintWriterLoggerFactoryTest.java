package com.sourceallies.filter;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;

import java.io.Writer;

import org.junit.Test;

public class PrintWriterLoggerFactoryTest {

	@Test
	public void testCreate(){
		PrintWriterLoggerFactory factory = new PrintWriterLoggerFactory();
		Writer mockWriter = mock(Writer.class);
		
		PrintWriterLogger printWriterLogger = factory.create(mockWriter);
		
		assertNotNull(printWriterLogger);
		assertSame(mockWriter, printWriterLogger.getWriter());
	}
}
