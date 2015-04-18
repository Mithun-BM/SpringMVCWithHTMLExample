package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//Second Way Of Spring MVC Controller
@Controller
@RequestMapping("/helloWorldMessage2")
public class HelloWorldController2{

	private static final Logger logger = LoggerFactory
			.getLogger(HelloWorldController2.class);

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String getHelloMessage(Model model) {
		logger.info("Inside HelloWorldController2 --> getHelloMessage()");
		return "HelloWorldController2 Spring MVC Framework!";
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String postHelloMessage(Model model) {
		logger.info("Inside HelloWorldController2 --> postHelloMessage()");
		return "HelloWorldController2 Spring MVC Framework! Data Posted Successfully";
	}

}

/*//Code Backup 
@Controller
@RequestMapping("/helloWorldMessage2")
public class HelloWorldController2{

	private static final Logger logger = LoggerFactory
			.getLogger(HelloWorldController1.class);

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String getHelloMessage(Model model) {
		logger.info("Inside HelloWorldController2 --> getHelloMessage");
		return "HelloWorldController2 Spring MVC Framework!";
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String postHelloMessage(Model model) {
		logger.info("Inside HelloWorldController2 --> postHelloMessage");
		return "HelloWorldController2 Spring MVC Framework! Data Posted Successfully";
	}

}
*/