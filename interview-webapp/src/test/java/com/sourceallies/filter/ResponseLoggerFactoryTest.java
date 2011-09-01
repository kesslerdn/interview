package com.sourceallies.filter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

public class ResponseLoggerFactoryTest {

	@Test
	public void testCreate(){
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		ResponseLoggerFactory factory = new ResponseLoggerFactory();
		ResponseLogger responseLogger = factory.create(response);
		assertNotNull(responseLogger);
		assertSame(response, responseLogger.getResponse());
	}
}
