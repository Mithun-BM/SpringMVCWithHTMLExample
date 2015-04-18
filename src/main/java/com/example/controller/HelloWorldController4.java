package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//Fourth Way Of Spring MVC Controller
@Controller
@RequestMapping
public class HelloWorldController4{

	private static final Logger logger = LoggerFactory
			.getLogger(HelloWorldController4.class);

	@RequestMapping(value = "/helloWorldMessage4/getHelloMessage" , method = RequestMethod.GET)
	@ResponseBody
	public String getHelloMessage(Model model) {
		logger.info("Inside HelloWorldController4 --> getHelloMessage()");
		return "HelloWorldController4 Spring MVC Framework!";
	}

	@RequestMapping(value = "/helloWorldMessage4/postHelloMessage" , method = RequestMethod.POST)
	@ResponseBody
	public String postHelloMessage(Model model) {
		logger.info("Inside HelloWorldController4 --> postHelloMessage()");
		return "HelloWorldController4 Spring MVC Framework! Data Posted Successfully";
	}
}

/*//Code Backup 
@Controller
@RequestMapping
public class HelloWorldController4{

	private static final Logger logger = LoggerFactory
			.getLogger(HelloWorldController1.class);

	@RequestMapping(value = "/helloWorldMessage4/getHelloMessage" , method = RequestMethod.GET)
	@ResponseBody
	public String getHelloMessage(Model model) {
		logger.info("Inside HelloWorldController4 --> getHelloMessage()");
		return "HelloWorldController4 Spring MVC Framework!";
	}

	@RequestMapping(value = "/helloWorldMessage4/postHelloMessage" , method = RequestMethod.POST)
	@ResponseBody
	public String postHelloMessage(Model model) {
		logger.info("Inside HelloWorldController4 --> postHelloMessage()");
		return "HelloWorldController4 Spring MVC Framework! Data Posted Successfully";
	}
}
*/