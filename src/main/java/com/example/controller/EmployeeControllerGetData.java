package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeControllerGetData {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeControllerGetData.class);

	@RequestMapping(value = "/getEmployeeData1stWay", method = RequestMethod.GET)
	public String getEmployeeFormData1stWay(Model model) 
	{
		//logger.info("Entering getEmployeeData1stWay()");
		
		//logger.info("Exiting getEmployeeData1stWay()");
		return "";
	}


	@RequestMapping(value = "/getEmployeeData2ndWay", method = RequestMethod.GET)
	public String getEmployeeData2ndWay(Model model) 
	{
	    //logger.info("Entering getEmployeeData2ndWay()");
		
		//logger.info("Exiting getEmployeeData2ndWay()");
		return "";
	}
	

}
