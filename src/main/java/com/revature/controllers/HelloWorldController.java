package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

	@RequestMapping(method=RequestMethod.GET, value="/home")
	public String getHomePage() {
		System.out.println("Hit Hello World controller...");
		return "Home";
	}
}
