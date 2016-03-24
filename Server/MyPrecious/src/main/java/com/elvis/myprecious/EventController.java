package com.elvis.myprecious;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elvis.myprecious.model.Event;
import com.elvis.myprecious.model.ResponseObject;
import com.elvis.myprecious.service.EventService;

@Controller
public class EventController {
	
	Logger logger = Logger.getLogger(EventController.class.getSimpleName());
	
	@Autowired
	EventService eventService;
	
	@RequestMapping(value = "admins/{adminId}/events", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseObject getEvent(HttpServletRequest request, @PathVariable int adminId) {
		logger.info("getEvent");
	
		
		ResponseObject response = new ResponseObject();
		response.code = 0;
		response.msg = null;
		response.body = eventService.getEvents(adminId);
		
		return response;
	}
	
	@RequestMapping(value = "admins/{adminId}/events", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseObject insertEvent(@PathVariable int adminId, @RequestBody Event event) {
		logger.info("insertEvent");
		
		event.setAdminId(adminId);
		eventService.insertEvents(event);
		
		ResponseObject response = new ResponseObject();
		response.code = 0;
		response.msg = "성공";
		response.body = event;
		
		return response;
	
	}
	
	@RequestMapping(value = "admins/{adminId}/events/{e_no}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public ResponseObject editEvent(@PathVariable int adminId, @RequestBody Event event, @PathVariable int e_no){
		event.setAdminId(adminId);
		event.setE_no(e_no);
		eventService.editEvents(event);
		
		ResponseObject response = new ResponseObject();
		response.code = 0;
		response.msg = "성공";
		response.body = event;
		
		return response;
	}
	
	@RequestMapping(value = "admins/{adminId}/events/{e_no}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public ResponseObject deleteEvent(@PathVariable int adminId, @PathVariable int e_no){
		eventService.deleteEvents(e_no);
		
		ResponseObject response = new ResponseObject();
		response.code = 0;
		response.msg = "성공";
		
		return response;
	}
	
	@RequestMapping(value = "events/{e_no}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseObject getEvent2(HttpServletRequest request, @PathVariable int e_no) {
		logger.info("getEvent");
	
		
		ResponseObject response = new ResponseObject();
		response.code = 0;
		response.msg = null;
		response.body = eventService.getEvents(e_no);
		
		return response;
	}
	 
}
