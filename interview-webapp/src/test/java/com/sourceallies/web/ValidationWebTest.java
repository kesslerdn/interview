package com.sourceallies.web;

import net.sourceforge.jwebunit.junit.WebTestCase;

public class ValidationWebTest extends WebTestCase{
	public void setUp() throws Exception{
		super.setUp();
		setBaseUrl("http://localhost:8888/interview-webapp");
	}

	public void testValid() {
		beginAt("/person/create.do");
		assertTitleEquals("Create Person");
		setTextField("firstName", "testFirstName");
		setTextField("lastName", "testLastName");
		submit();
		assertTitleEquals("Create Person");
		assertElementNotPresent("firstName.errors");
	}
	
	public void testInValid() {
		beginAt("/person/create.do");
		assertTitleEquals("Create Person");
		setTextField("firstName", "");
		setTextField("lastName", "");
		submit();
		assertTitleEquals("Create Person");
		assertElementPresent("firstName.errors");
	}

}
