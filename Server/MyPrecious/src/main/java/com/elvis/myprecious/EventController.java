package com.elvis.myprecious;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elvis.myprecious.model.ResponseObject;
import com.elvis.myprecious.service.EventService;

@Controller
public class EventController {
	
	Logger logger = Logger.getLogger(EventController.class.getSimpleName());
	
	@Autowired
	EventService eventService;
	
	@RequestMapping(value = "admin/{adminId}/event", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseObject getEvent(HttpServletRequest request, @PathVariable int adminId) {
		logger.info("getEvent");
	
		
		ResponseObject response = new ResponseObject();
		response.code = 0;
		response.msg = null;
		response.body = eventService.getEvents(adminId);
		
		return response;
	}
}
