package com.sourceallies.filter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;


public class ResponseLogFilterTest {

	@Test
	public void testInjectResponseProxy() throws IOException, Exception{
		ResponseLogFilter filter = new ResponseLogFilter();
		
		ServletRequest mockRequest = mock(ServletRequest.class);
		HttpServletResponse mockResponse = mock(HttpServletResponse.class);
		FilterChain mockFilter = mock(FilterChain.class);
		ResponseLoggerFactory mockResponseLoggerFactory = mock(ResponseLoggerFactory.class);
		ResponseLogger mockResponseLogger = mock(ResponseLogger.class);
		
		when(mockResponseLoggerFactory.create(mockResponse)).thenReturn(mockResponseLogger);
		
		filter.setResponseLoggerFactory(mockResponseLoggerFactory);
		
		filter.doFilter(mockRequest, mockResponse, mockFilter);
		
		verify(mockFilter).doFilter(mockRequest, mockResponseLogger);
	}
}
