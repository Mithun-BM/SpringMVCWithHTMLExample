package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Message;
import com.example.entity.SubMessage;


@Controller
public class MessageControllerGETUsingResponseBody 
{

	private static final Logger logger = LoggerFactory.getLogger(MessageControllerGETUsingResponseBody.class);

	@RequestMapping(value = "/getMessageReturningString", method = RequestMethod.GET)
	@ResponseBody//Simple string response is sent using @ResponseBody 
	public String getMessageReturningString() 
	{
		logger.info("Inside getMessageReturningString()");
		String responseMessage = "Hello World Returning String";
		logger.info("Exiting getMessageReturningString()");
		return responseMessage;

		/*Code Backup - 
		logger.info("Inside getMessageReturningString()");
		String responseMessage = "Hello World Returning String";
		logger.info("Exiting getMessageReturningString()");
		return responseMessage;*/
	}

	//Building JSON response using JSONObject.
	@RequestMapping(value = "/getMessageReturningJSONResponseFirstWay", method = RequestMethod.GET)
	@ResponseBody//JSON response is sent as string using @ResponseBody and has to be parsed in UI using var responsedata= $.parseJSON(html);.
	public String getMessageReturningJSONResponseFirstWay() throws JsonGenerationException, JsonMappingException, IOException 
	{
		logger.info("Inside getMessageReturningJSONResponseFirstWay()");
		String responseMessage = "Hello World Returned Using JSON Response First Way";
		JSONObject jobj = new JSONObject();
		try {
			jobj.put("messageContent", responseMessage);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		logger.info("Exiting getMessageReturningJSONResponseFirstWay()");
		//return new ObjectMapper().writeValueAsString(jobj);//This does not work because the jobj has to be converted into string.
		return new ObjectMapper().writeValueAsString(jobj.toString());//In UI I get response as JSON string, 
		//which has to be parsed using var responsedata = $.parseJSON(html); finally responsedata will be of JSON object type.


		/*Code Backup - 
		 logger.info("Inside getMessageReturningJSONResponseFirstWay()");
		String responseMessage = "Hello World Returned Using JSON Response First Way";
		JSONObject jobj = new JSONObject();
		try {
			jobj.put("messageContent", responseMessage);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		logger.info("Exiting getMessageReturningJSONResponseFirstWay()");
		//return new ObjectMapper().writeValueAsString(jobj);//This does not work because the jobj has to be converted into string.
		return new ObjectMapper().writeValueAsString(jobj.toString());//In UI I get response as JSON string, 
		//which has to be parsed using var responsedata = $.parseJSON(html); finally responsedata will be of JSON object type.
		 */
	}

	//Building JSON response using JSONObject.
	@RequestMapping(value = "/getMessageReturningJSONResponseSecondWay", method = RequestMethod.GET)
	@ResponseBody//JSON response is sent as JSON object using @ResponseBody and no need to parse in UI using var responsedata= $.parseJSON(html);.
	public String getMessageReturningJSONResponseSecondWay() throws JsonGenerationException, JsonMappingException, IOException 
	{
		logger.info("Inside getMessageReturningJSONResponseSecondWay()");
		String responseMessage = "Hello World Returned Using JSON Response Second Way";
		JSONObject jobj = new JSONObject();
		try {
			jobj.put("messageContent", responseMessage);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		logger.info("Exiting getMessageReturningJSONResponseSecondWay()");
		return jobj.toString();//Eventhough I say jobj.toString() in UI I get response as JSON object and not JSON string.


		/*Code Backup - 
		 logger.info("Inside getMessageReturningJSONResponseSecondWay");
		String responseMessage = "Hello World Returned Using JSON Response Second Way";
		JSONObject jobj = new JSONObject();
		try {
			jobj.put("messageContent", responseMessage);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		logger.info("Exiting getMessageReturningJSONResponseSecondWay");
		return jobj.toString();//Eventhough I say jobj.toString() in UI I get response as JSON object and not JSON string.
		 */	}

	//Building JSON response using Databinding or Reflection Concept
	@RequestMapping(value = "/getMessageJSONResponseUsingDataBinding", method = RequestMethod.GET)
	@ResponseBody//Response is sent using @ResponseBody 
	public String getMessageJSONResponseUsingDataBinding() throws JsonGenerationException, JsonMappingException, IOException, JSONException 
	{
		logger.info("Inside getMessageJSONResponseUsingDataBinding()");
		Message message1 = new Message();
		message1.setMessageId(1);
		message1.setMessageContent("Message Content From Message Obj1");
		message1.setMessageTime("16-03-2015");

		SubMessage submessage = new SubMessage();
		submessage.setSubmessageId(2);
		submessage.setSubmessageContent("Sub Message Content From submessage Obj1");

		message1.setSubmessage(submessage);

		new ObjectMapper().writeValue(new File("/home/emithbm/Logs_Files/Message.json"), message1);//Writing the response into an external .json file

		logger.info("Exiting getMessageJSONResponseUsingDataBinding()");
		//return new ObjectMapper().writeValueAsString(message1.toString());//This is wrong brain storm.
		return new ObjectMapper().writeValueAsString(message1);//If using Databinding or Reflection concept then dont convert new ObjectMapper().writeValueAsString(message1.toString()).

		/*Code backup - 
	   logger.info("Inside getMessageJSONResponseUsingDataBinding()");
		Message message1 = new Message();
		message1.setMessageId(1);
		message1.setMessageContent("Message Content From Message Obj1");
		message1.setMessageTime("16-03-2015");

		SubMessage submessage = new SubMessage();
		submessage.setSubmessageId(2);
		submessage.setSubmessageContent("Sub Message Content From submessage Obj1");

		message1.setSubmessage(submessage);

		new ObjectMapper().writeValue(new File("/home/emithbm/Logs_Files/Message.json"), message1);//Writing the response into an external .json file

		logger.info("Exiting getMessageJSONResponseUsingDataBinding()");
		//return new ObjectMapper().writeValueAsString(message1.toString());//This is wrong brain storm.
		return new ObjectMapper().writeValueAsString(message1);//If using Databinding or Reflection concept then dont convert new ObjectMapper().writeValueAsString(message1.toString()). 
		 */	}

	//Building JSON response using  Databinding or Reflection Concept
	@RequestMapping(value = "/getMessageListJSONResponseUsingDataBinding", method = RequestMethod.GET)
	@ResponseBody//Response is sent using @ResponseBody 
	public String getMessageListJSONResponseUsingDataBinding() throws JsonGenerationException, JsonMappingException, IOException 
	{
		logger.info("Inside getMessageListJSONResponseUsingDataBinding()");
		Message message1 = new Message();
		message1.setMessageId(1);
		message1.setMessageContent("Message Content From Message Obj1");
		message1.setMessageTime("16-03-2015");

		SubMessage submessage1 = new SubMessage();
		submessage1.setSubmessageId(3);
		submessage1.setSubmessageContent("Sub Message Content From submessage Obj1");

		message1.setSubmessage(submessage1);


		Message message2 = new Message();
		message2.setMessageId(2);
		message2.setMessageContent("Message Content From Message Obj2");
		message2.setMessageTime("17-03-2015");

		SubMessage submessage2 = new SubMessage();
		submessage2.setSubmessageId(4);
		submessage2.setSubmessageContent("Sub Message Content From submessage Obj2");

		message2.setSubmessage(submessage2);

		Message message3 = new Message();
		message3.setMessageId(3);
		message3.setMessageContent("Message Content From Message Obj3");
		message3.setMessageTime("18-03-2015");

		SubMessage submessage3 = new SubMessage();
		submessage3.setSubmessageId(5);
		submessage3.setSubmessageContent("Sub Message Content From submessage Obj3");

		message3.setSubmessage(submessage3);

		List<Message> msglist = new ArrayList<Message>();
		msglist.add(message1);
		msglist.add(message2);
		msglist.add(message3);

		new ObjectMapper().writeValue(new File("/home/emithbm/Logs_Files/MessageList.json"), msglist);//Writing the response into an external .json file

		logger.info("Exiting getMessageListJSONResponseUsingDataBinding()");
		//return new ObjectMapper().writeValueAsString(msglist.toString());//This is wrong brain.
		return new ObjectMapper().writeValueAsString(msglist);//If using Databinding or Reflection concept then dont convert new ObjectMapper().writeValueAsString(message1.toString()).


		/*Code Backup - 
	logger.info("Inside getMessageListJSONResponseUsingDataBinding()");
		Message message1 = new Message();
		message1.setMessageId(1);
		message1.setMessageContent("Message Content From Message Obj1");
		message1.setMessageTime("16-03-2015");

		SubMessage submessage1 = new SubMessage();
		submessage1.setSubmessageId(3);
		submessage1.setSubmessageContent("Sub Message Content From submessage Obj1");

		message1.setSubmessage(submessage1);


		Message message2 = new Message();
		message2.setMessageId(2);
		message2.setMessageContent("Message Content From Message Obj2");
		message2.setMessageTime("17-03-2015");

		SubMessage submessage2 = new SubMessage();
		submessage2.setSubmessageId(4);
		submessage2.setSubmessageContent("Sub Message Content From submessage Obj2");

		message2.setSubmessage(submessage2);

		Message message3 = new Message();
		message3.setMessageId(3);
		message3.setMessageContent("Message Content From Message Obj3");
		message3.setMessageTime("18-03-2015");

		SubMessage submessage3 = new SubMessage();
		submessage3.setSubmessageId(5);
		submessage3.setSubmessageContent("Sub Message Content From submessage Obj3");

		message3.setSubmessage(submessage3);

		List<Message> msglist = new ArrayList<Message>();
		msglist.add(message1);
		msglist.add(message2);
		msglist.add(message3);

		new ObjectMapper().writeValue(new File("/home/emithbm/Logs_Files/MessageList.json"), msglist);//Writing the response into an external .json file

		logger.info("Exiting getMessageListJSONResponseUsingDataBinding()");
		//return new ObjectMapper().writeValueAsString(msglist.toString());//This is wrong brain.
		return new ObjectMapper().writeValueAsString(msglist);//If using Databinding or Reflection concept then dont convert new ObjectMapper().writeValueAsString(message1.toString()).
		 */
	}

	@RequestMapping(value = "/getMessageReturningXMLResponse", method = RequestMethod.GET)
	@ResponseBody//Response is sent using @ResponseBody 
	public String getMessageReturningXMLResponse() 
	{
		logger.info("Inside getMessageReturningXMLResponse()");
		String responseMessage = "<Message><mesageId>1</mesageId><mesageContent>Msg1 XML Response</mesageContent><mesageTime>16-03-2015</mesageTime><SubMessage><submessageId>3</submessageId><submessageContent>Sub Message1 XML Response</submessageContent></SubMessage></Message>";
		//<Message><Message><mesageId>1</mesageId><mesageContent>Msg1 XML Response</mesageContent><mesageTime>16-03-2015</mesageTime><SubMessage><submessageId>3</submessageId><submessageContent>Sub Message1 XML Response</submessageContent></SubMessage></Message><Message><mesageId>2</mesageId><mesageContent>Msg2 XML Response</mesageContent><mesageTime>18-03-2015</mesageTime><SubMessage><submessageId>4</submessageId><submessageContent>Sub MsgXML Response</submessageContent></SubMessage></Message></Message>
		logger.info("Exiting getMessageReturningXMLResponse()");
		return responseMessage;

		/*Code Backup -
		logger.info("Inside getMessageReturningXMLResponse()");
		String responseMessage = "<Message><mesageId>1</mesageId><mesageContent>Msg1 XML Response</mesageContent><mesageTime>16-03-2015</mesageTime><SubMessage><submessageId>3</submessageId><submessageContent>Sub Message1 XML Response</submessageContent></SubMessage></Message>";
		//<Message><Message><mesageId>1</mesageId><mesageContent>Msg1 XML Response</mesageContent><mesageTime>16-03-2015</mesageTime><SubMessage><submessageId>3</submessageId><submessageContent>Sub Message1 XML Response</submessageContent></SubMessage></Message><Message><mesageId>2</mesageId><mesageContent>Msg2 XML Response</mesageContent><mesageTime>18-03-2015</mesageTime><SubMessage><submessageId>4</submessageId><submessageContent>Sub MsgXML Response</submessageContent></SubMessage></Message></Message>
		logger.info("Exiting getMessageReturningXMLResponse()");
		return responseMessage;*/
	}

	@RequestMapping(value = "/getMessageListReturningXMLResponse", method = RequestMethod.GET)
	@ResponseBody//Response is sent using @ResponseBody 
	public String getMessageListReturningXMLResponse() 
	{
		logger.info("Inside getMessageListReturningXMLResponse()");
		String responseMessage = "<Message><Message><mesageId>1</mesageId><mesageContent>Msg1 XML Response</mesageContent><mesageTime>16-03-2015</mesageTime><SubMessage><submessageId>3</submessageId><submessageContent>Sub Message1 XML Response</submessageContent></SubMessage></Message><Message><mesageId>2</mesageId><mesageContent>Msg2 XML Response</mesageContent><mesageTime>18-03-2015</mesageTime><SubMessage><submessageId>4</submessageId><submessageContent>Sub MsgXML Response</submessageContent></SubMessage></Message></Message>";
		logger.info("Exiting getMessageListReturningXMLResponse()");
		return responseMessage;

		/*Code Backup -
		logger.info("Inside getMessageListReturningXMLResponse()");
		String responseMessage = "<Message><Message><mesageId>1</mesageId><mesageContent>Msg1 XML Response</mesageContent><mesageTime>16-03-2015</mesageTime><SubMessage><submessageId>3</submessageId><submessageContent>Sub Message1 XML Response</submessageContent></SubMessage></Message><Message><mesageId>2</mesageId><mesageContent>Msg2 XML Response</mesageContent><mesageTime>18-03-2015</mesageTime><SubMessage><submessageId>4</submessageId><submessageContent>Sub MsgXML Response</submessageContent></SubMessage></Message></Message>";
		logger.info("Exiting getMessageListReturningXMLResponse()");
		return responseMessage;*/
	}

	//@PathVariable Usage Example
	@RequestMapping(value = "/pathVariableDemo/{msgId}", method = RequestMethod.GET)
	@ResponseBody//Response is sent using @ResponseBody 
	public String pathVariableDemo(@PathVariable("msgId") String msgId) //@PathVariable is equivalent to @PathParam in REST.
	{
		logger.info("Inside pathVariableDemo()");
		System.out.println("MessageId sent as PathVariable is :" + msgId);
		logger.info("Exiting pathVariableDemo()");
		return msgId;

		/*	Code Backup -
	 logger.info("Inside pathVariableDemo()");
		System.out.println("MessageId sent as PathVariable is :" + msgId);
		logger.info("Exiting pathVariableDemo()");
		return msgId;*/
	}

	//@RequestParam Usage Example
	@RequestMapping(value = "/requestParamDemo", method = RequestMethod.GET)
	@ResponseBody//Response is sent using @ResponseBody 
	public String requestParamDemo(@RequestParam("date") String date) //@RequestParam is equivalent to @QueryParam in REST.
	{
		logger.info("Inside requestParamDemo()");
		System.out.println("Date sent as RequestParam is :" + date);
		logger.info("Exiting requestParamDemo()");
		return date;

		/*	Code Backup -
	 logger.info("Inside requestParamDemo()");
		System.out.println("Date sent as RequestParam is :" + date);
		logger.info("Exiting requestParamDemo()");
		return date;*/
	}

	@RequestMapping(value = "/requestParamValidationDemo", method = RequestMethod.GET)
	@ResponseBody//Response is sent using @ResponseBody 
	public String requestParamValidationDemo(@RequestParam(value = "date" , required = false , defaultValue="defaultValueTaken") String date) //@RequestParam is equivalent to @QueryParam in REST
	{
		logger.info("Inside requestParamValidationDemo()");
		System.out.println("Date sent as RequestParam is :" + date);
		logger.info("Exiting requestParamValidationDemo()");
		return date;
	}

	//@RequestParam Usage Example 2nd Way
	@RequestMapping(value = "/requestParamDemo2ndWay", method = RequestMethod.GET , params = "date")
	@ResponseBody//Response is sent using @ResponseBody 
	public String requestParamDemo2ndWay(@RequestParam("date") String date)
	{
		//params = "date"  means date should be sent from UI. If date is missed then it wont hit the controller.
		logger.info("Inside requestParamDemo2ndWay()");
		System.out.println("Date sent as RequestParam is :" + date);
		logger.info("Exiting requestParamDemo2ndWay()");
		return date;
	}

	//experiment the below
	//@RequestParam Usage Example Experiment - Accepting Multiple Parameters from UI
	@RequestMapping(value = "/requestParamDemoExperiment", method = RequestMethod.GET , params = {"date" , "name" , "age"})
	@ResponseBody//Response is sent using @ResponseBody 
	public String requestParamDemoExperiment(@RequestParam("date") String date , @RequestParam("name") String name , @RequestParam("age") String age)
	{
		//params = {"date" , "name" , "age"} means all three parameters name, age & date should be sent mandatorily from UI. If any one missed then it wont hit the controller.
		logger.info("Inside requestParamDemoExperiment()");
		System.out.println("Date sent as RequestParam is :" + date);
		System.out.println("Date sent as RequestParam is :" + name);
		System.out.println("Date sent as RequestParam is :" + age);
		String returnValue = "Parameter from UI : " + name + date + age;
		logger.info("Exiting requestParamDemoExperiment()");
		return returnValue;
	}
}