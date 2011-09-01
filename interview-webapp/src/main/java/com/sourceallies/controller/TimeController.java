package com.sourceallies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/show/time.do")
public class TimeController {
	
	@RequestMapping(method = RequestMethod.GET)
    public void showPage() {
        
    }

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String retrieveTime() {
		return "The current time in milliseconds is: " + System.currentTimeMillis();
	}
}
