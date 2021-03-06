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
import com.elvis.myprecious.model.Item;
import com.elvis.myprecious.model.ResponseObject;
import com.elvis.myprecious.service.EventService;
import com.elvis.myprecious.service.ItemService;

@Controller
@RequestMapping(value = "")
public class ItemController {

	Logger logger = Logger.getLogger(ItemController.class.getSimpleName());
	@Autowired
	EventService eventService;

	@Autowired
	ItemService itemService;

	@RequestMapping(value = "wv/admins/{adminId}/events/{e_no}/items", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseObject getAdmin(HttpServletRequest request, @PathVariable int adminId, @PathVariable int e_no) {
		logger.info("getItem");
		
		ResponseObject response = new ResponseObject();
		response.code = 0;
		response.msg = null;
		response.body = itemService.getItems(adminId, e_no);

		return response;
	}
	
	@RequestMapping(value = "wv/admins/{adminId}/events/{e_no}/items", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseObject insertItem(@PathVariable("adminId") int adminId, @PathVariable("e_no") int e_no, @RequestBody Item item) {
		logger.info("insertItem");
		
		item.setI_e_no(e_no);
		itemService.insertItems(item);
		
		ResponseObject response = new ResponseObject();
		response.code = 0;
		response.msg = "성공";
		response.body = item;
		
		return response;
	}
	 
	@RequestMapping(value = "wv/admins/{adminId}/events/{e_no}/items/{i_no}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public ResponseObject editItem(@PathVariable("adminId") int adminId, @PathVariable("e_no") int e_no, @PathVariable("i_no") int i_no, @RequestBody Item item){
		item.setI_e_no(i_no);
		itemService.editItems(item);
		
		ResponseObject response = new ResponseObject();
		response.code = 0;
		response.msg = "성공";
		response.body = item;
		
		return response;
	}
	
	@RequestMapping(value = "wv/admins/{adminId}/events/{e_no}/items/{i_no}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public ResponseObject deleteItem(@PathVariable int i_no){
		itemService.deleteItems(i_no);
		
		ResponseObject response = new ResponseObject();
		response.code = 0;
		response.msg = "성공";
		
		return response;
	}
	
	@RequestMapping(value = "av/events/{e_no}/items", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseObject getItem2(HttpServletRequest request, @PathVariable int e_no) {
		
		ResponseObject response = new ResponseObject();
		response.code = 0;
		response.msg = null;
		response.body = itemService.getItem2s(e_no);
		
		return response;
	}
	
	@RequestMapping(value = "av/events/{e_no}/items/{i_no}/users/{u_phonenumber}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public ResponseObject editItem2(@PathVariable("e_no") int e_no, @PathVariable("i_no") int i_no, @RequestBody Item item, @PathVariable("u_phonenumber") int u_phonenumber){
		item.setI_no(i_no);
		itemService.editItems(item);
		
		ResponseObject response = new ResponseObject();
		response.code = 0;
		response.msg = "성공";
		response.body = item;
		
		return response;
	}
}
