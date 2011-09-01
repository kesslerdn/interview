package com.sourceallies.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class ResponseLogFilter implements Filter {
	
	ResponseLoggerFactory responseLoggerFactory = new ResponseLoggerFactory();
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, responseLoggerFactory.create((HttpServletResponse) response));
	}

	@Override
	public void init(FilterConfig config) throws ServletException {}

	public void setResponseLoggerFactory(ResponseLoggerFactory responseLoggerFactory) {
		this.responseLoggerFactory = responseLoggerFactory;
	}
}
