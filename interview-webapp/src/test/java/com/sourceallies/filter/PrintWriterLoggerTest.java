package com.sourceallies.filter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.Writer;

import org.apache.commons.logging.Log;
import org.junit.Test;

public class PrintWriterLoggerTest {

	@Test
	public void testWrite(){
		Writer mockWriter = mock(Writer.class);
		PrintWriterLogger printWriterLogger = new PrintWriterLogger(mockWriter);
		Log mockLogger = mock(Log.class);
		
		printWriterLogger.setLogger(mockLogger);
		
		printWriterLogger.write(new char[]{'t','e','s','t'}, 0, 0);
		
		verify(mockLogger).info("response:\ntest");
	}
}
