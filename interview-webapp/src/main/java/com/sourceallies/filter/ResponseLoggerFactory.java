package com.sourceallies.filter;

import javax.servlet.http.HttpServletResponse;

public class ResponseLoggerFactory {

	public ResponseLogger create(HttpServletResponse response) {
		return new ResponseLogger(response);
	}

}
