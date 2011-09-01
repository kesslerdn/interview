package com.sourceallies.web;

import net.sourceforge.jwebunit.htmlunit.HtmlUnitTestingEngineImpl;
import net.sourceforge.jwebunit.junit.WebTestCase;

import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;

public class AjaxWebTest  extends WebTestCase{
	public void setUp() throws Exception{
		super.setUp();
		setBaseUrl("http://localhost:8888/interview-webapp");
	}

	public void testWithoutAjaxEnabled() {
		beginAt("/show/time.do");
		assertTitleEquals("Show Time");
		assertTextNotInElement("time", "The current time in milliseconds is: ");
		clickButton("retrieveTime");
		assertTextNotInElement("time", "The current time in milliseconds is: ");
	}
	
	public void testWithAjaxEnabled() {
		beginAt("/show/time.do");
		
		HtmlUnitTestingEngineImpl engine = (HtmlUnitTestingEngineImpl) getTestingEngine();
		WebClient webClient = engine.getWebClient();
		webClient.waitForBackgroundJavaScript(10000);
		webClient.setAjaxController(new NicelyResynchronizingAjaxController());
		
		assertTitleEquals("Show Time");
		assertTextNotInElement("time", "The current time in milliseconds is: ");
		clickButton("retrieveTime");
		assertTextInElement("time", "The current time in milliseconds is: ");
	}
}
