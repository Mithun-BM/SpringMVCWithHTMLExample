package com.example.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Message;



@Controller
public class MessageControllerPOSTData 
{
	private static final Logger logger = LoggerFactory
			.getLogger(MessageControllerPOSTData.class);

	//Posting simple string data
	@RequestMapping(value = "/postStringData", method = RequestMethod.POST)
	@ResponseBody//Response is sent using @ResponseBody 
	public String postStringData(@RequestBody String message) throws JsonGenerationException, JsonMappingException, IOException
	{//@RequestBody can accept string, XML ,JSON data based on contentType set in UI.
		logger.info("Inside postStringData()");
		System.out.println("Simple string message from UI is:" + message);
		logger.info("Exiting postStringData()");
		return message;

		/*Code Backup - 
		 logger.info("Inside postStringData()");
		System.out.println("Simple string message from UI is:" + message);
		logger.info("Exiting postStringData()");
		return message;*/
	}

	//Posting JSON Data
	@RequestMapping(value = "/postJSONData", method = RequestMethod.POST)
	@ResponseBody//Response is sent using @ResponseBody 
	public String postJSONData(@RequestBody String message) throws JsonGenerationException, JsonMappingException, IOException
	{//@RequestBody accept JSON data based on contentType set in UI.
		logger.info("Inside postJSONData()");
		Message mesobj = new ObjectMapper().readValue(message, Message.class);
		System.out.println("JSON MessageId from UI is:" + mesobj.getMessageId());
		System.out.println("JSON MessageContent from UI is:" + mesobj.getMessageContent());
		System.out.println("JSON MessageTime from UI is:" + mesobj.getMessageTime());
		System.out.println("JSON SubmessageId from UI is:" + mesobj.getSubmessage().getSubmessageId());
		System.out.println("JSON SubmessageContent from UI is:" + mesobj.getSubmessage().getSubmessageContent());
		logger.info("Exiting postJSONData()");
		return new ObjectMapper().writeValueAsString(mesobj);

		/*Code Backup - 
		logger.info("Inside postJSONData()");
		Message mesobj = new ObjectMapper().readValue(message, Message.class);
		System.out.println("JSON MessageId from UI is:" + mesobj.getMessageId());
		System.out.println("JSON MessageContent from UI is:" + mesobj.getMessageContent());
		System.out.println("JSON MessageTime from UI is:" + mesobj.getMessageTime());
		System.out.println("JSON SubmessageId from UI is:" + mesobj.getSubmessage().getSubmessageId());
		System.out.println("JSON SubmessageContent from UI is:" + mesobj.getSubmessage().getSubmessageContent());
		logger.info("Exiting postJSONData()");
		return new ObjectMapper().writeValueAsString(mesobj);*/
	}

	//Posting List of JSON Data
	@RequestMapping(value = "/postJSONListData", method = RequestMethod.POST)
	@ResponseBody//Response is sent using @ResponseBody 
	public String postListOfJSONData(@RequestBody String messageList) throws JsonGenerationException, JsonMappingException, IOException
	{//@RequestBody accept JSON data based on contentType set in UI.
		logger.info("Inside postJSONListData()");
		List<Message> msgList = new ObjectMapper().readValue(messageList, new TypeReference<List<Message>>(){});//Brain Storm On This
		for (Message message : msgList) {
			System.out.println(message.getMessageId());
			System.out.println(message.getMessageContent());
			System.out.println(message.getMessageTime());
			System.out.println(message.getSubmessage().getSubmessageId());
			System.out.println(message.getSubmessage().getSubmessageContent());
		}
		logger.info("Exiting postJSONListData()");
		return new ObjectMapper().writeValueAsString(msgList);

		/*Code Backup - 
		logger.info("Inside postJSONListData()");
		List<Message> msgList = new ObjectMapper().readValue(messageList, new TypeReference<List<Message>>(){});//Brain Storm On This
		for (Message message : msgList) {
			System.out.println(message.getMessageId());
			System.out.println(message.getMessageContent());
			System.out.println(message.getMessageTime());
			System.out.println(message.getSubmessage().getSubmessageId());
			System.out.println(message.getSubmessage().getSubmessageContent());
		}
		logger.info("Exiting postJSONListData()");
		return new ObjectMapper().writeValueAsString(msgList);*/
	}

	//Posting XML Data
	@RequestMapping(value = "/postXMLData", method = RequestMethod.POST)
	@ResponseBody//Response is sent using @ResponseBody 
	public String postXMLData(@RequestBody String message)
	{//@RequestBody accept XML data based on contentType set in UI.
		logger.info("Inside postXMLData()");
		//Bring here JAXB technology to parse xml content into java object.
		System.out.println("XML Message from UI is:" + message);
		logger.info("Exiting postXMLData()");
		return "";
	}

	//Posting XML List Data
	@RequestMapping(value = "/postXMLListData", method = RequestMethod.POST)
	@ResponseBody//Response is sent using @ResponseBody 
	public String postXMLListData(@RequestBody String message)
	{//@RequestBody accept XML data based on contentType set in UI.
		logger.info("Inside postXMLData()");
		//Bring here JAXB technology to parse xml content into java object.
		System.out.println("XML List Message from UI is:" + message);
		logger.info("Exiting postXMLData()");
		return "";
	}

	//@RequestHeader Usage Eaxmple First Way 
	@RequestMapping(value = "/messageRequestHeaderPost1stWay" , method = RequestMethod.POST)
	@ResponseBody
	public String messageRequestHeaderPost1stWay(@RequestHeader(value="User-Agent") String userAgent,@RequestHeader(value="My-First-Header") String firstHeader ,@RequestHeader(value="My-Second-Header") String secondHeader) 
	{
		// receiving header parameters using @RequestHeader(value="User-Agent") String userAgent.
		logger.info("Entering messageRequestHeaderPost1stWay()");

		System.out.println("userAgent: " + userAgent);
		System.out.println("firstHeader: " + firstHeader);
		System.out.println("secondHeader: " + secondHeader);
		String returnValue = "userAgent: " + userAgent + "\n" + "firstHeader: " + firstHeader + "\n" + "secondHeader: " + secondHeader ;
		//System.out.println("acceptLanguage: " + acceptLanguage);
		logger.info("Exiting messageRequestHeaderPost1stWay()");
		return returnValue;
	}

	//@RequestHeader Usage Example Second Way 
	@RequestMapping(value = "/messageRequestHeaderPost2ndWay", method = RequestMethod.POST)
	@ResponseBody
	public String messageRequestHeaderPost2ndWay(@RequestHeader MultiValueMap<String,String> headers) 
	{
		// receiving list of header parameters using @RequestHeader MultiValueMap<String,String> headers
		logger.info("Entering messageRequestHeaderPost2ndWay()");
		for (String iterable_element : headers.keySet()) {//[host, connection, content-length, origin, my-first-header, user-agent, content-type, accept, x-requested-with, my-third-header, my-second-header, referer, accept-encoding, accept-language, cookie]
			System.out.println(iterable_element+" : " + headers.get(iterable_element));
		}
		System.out.println(headers.get("user-agent"));
		System.out.println(headers.get("my-first-header"));
		System.out.println(headers.get("my-second-header"));
		System.out.println(headers.get("my-third-header"));
		String returnValue = "userAgent: " + headers.get("user-agent") + "\n" + "firstHeader: " + headers.get("my-first-header") + "\n" + "secondHeader: " + headers.get("my-second-header") + "\n" +"thirdHeader: " + headers.get("my-third-header");
		logger.info("Entering messageRequestHeaderPost2ndWay()");
		return returnValue;
	}

	//@RequestHeader Usage Eaxmple Third Way 
	@RequestMapping(value = "/messageRequestHeaderPost3rdWay" , method = RequestMethod.POST , headers = "My-First-Header")
	@ResponseBody
	public String messageRequestHeaderPost3rdWay(@RequestHeader(value="My-First-Header") String firstHeader) 
	{
		//header parameters My-First-Header has to be sent mandatorily from UI.
		logger.info("Entering messageRequestHeaderPost3rdWay()");
		String returnValue = "firstHeader: " + firstHeader;
		logger.info("Exiting messageRequestHeaderPost3rdWay()");
		return returnValue;
	}

	//experiment the below
	//@RequestHeader Usage Eaxmple Experiment
	@RequestMapping(value = "/messageRequestHeaderPostExperiment" , method = RequestMethod.POST , headers = {"My-First-Header" , "My-Second-Header"})
	@ResponseBody
	public String messageRequestHeaderPostExperiment(@RequestHeader(value="My-First-Header") String firstHeader , @RequestHeader(value="My-Second-Header") String secondHeader) 
	{
		//header parameters My-First-Header & My-Second-Header has to be sent mandatorily from UI.
		logger.info("Entering messageRequestHeaderPostExperiment()");
		String returnValue = "firstHeader: " + firstHeader + "\n" + "secondHeader: " + secondHeader ;
		logger.info("Exiting messageRequestHeaderPostExperiment()");
		return returnValue;
	}

	//experiment the below
	//produces={"application/json"} , produces={"application/xml"}  , consumes={"application/json"} , consumes={"application/xml"}
	//Posting JSON Data
	@RequestMapping(value = "/postJSONDataExperiment", method = RequestMethod.POST , produces = {"application/json"} , consumes = {"application/json"})
	@ResponseBody//Response is sent using @ResponseBody 
	public String postJSONDataExperiment(@RequestBody String message) throws JsonGenerationException, JsonMappingException, IOException
	{//@RequestBody accept JSON data based on contentType set in UI.
		logger.info("Inside postJSONData()");
		Message mesobj = new ObjectMapper().readValue(message, Message.class);
		System.out.println("JSON MessageId from UI is:" + mesobj.getMessageId());
		System.out.println("JSON MessageContent from UI is:" + mesobj.getMessageContent());
		System.out.println("JSON MessageTime from UI is:" + mesobj.getMessageTime());
		System.out.println("JSON SubmessageId from UI is:" + mesobj.getSubmessage().getSubmessageId());
		System.out.println("JSON SubmessageContent from UI is:" + mesobj.getSubmessage().getSubmessageContent());
		logger.info("Exiting postJSONData()");
		return new ObjectMapper().writeValueAsString(mesobj);
	}
}