package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeControllerPostData {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeControllerPostData.class);
	
	//First Way 
	@RequestMapping(value = "/employeeRequestHeaderPost1stWay" , method = RequestMethod.POST)
	@ResponseBody
	public String employeeRequestHeaderPost1stWay(@RequestHeader(value="User-Agent") String userAgent,@RequestHeader(value="My-First-Header") String firstHeader ,@RequestHeader(value="My-Second-Header") String secondHeader) 
	{
		// receiving header parameters using @RequestHeader(value="User-Agent") String userAgent.
		logger.info("Entering employeeRequestHeaderPost1stWay()");
		
		System.out.println("userAgent: " + userAgent);
		System.out.println("firstHeader: " + firstHeader);
		System.out.println("secondHeader: " + secondHeader);

		//System.out.println("acceptLanguage: " + acceptLanguage);
		logger.info("Exiting employeeRequestHeaderPost1stWay()");
		return "";
	}

	//Second Way 
	@RequestMapping(value = "/employeeRequestHeaderPost2ndWay", method = RequestMethod.POST)
	@ResponseBody
	public String employeeRequestHeaderPost2ndWay(@RequestHeader MultiValueMap<String,String> headers) 
	{
		// receiving list of header parameters using @RequestHeader MultiValueMap<String,String> headers
		logger.info("Entering employeeRequestHeaderPost2ndWay()");
		for (String iterable_element : headers.keySet()) {//[host, connection, content-length, origin, my-first-header, user-agent, content-type, accept, x-requested-with, my-third-header, my-second-header, referer, accept-encoding, accept-language, cookie]
			System.out.println(iterable_element+" : " + headers.get(iterable_element));
		}
		System.out.println(headers.get("user-agent"));
		System.out.println(headers.get("my-first-header"));
		System.out.println(headers.get("my-second-header"));
		System.out.println(headers.get("my-third-header"));
		logger.info("Entering employeeRequestHeaderPost2ndWay()");
		return "";
	}

}
