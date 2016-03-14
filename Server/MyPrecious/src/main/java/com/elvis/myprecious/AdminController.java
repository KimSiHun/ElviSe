package com.elvis.myprecious;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elvis.myprecious.model.ResponseObject;
import com.elvis.myprecious.service.AdminService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	Logger logger = Logger.getLogger(AdminController.class.getSimpleName());
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value="", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseObject getAdmin(HttpServletRequest request) {
		logger.info("getAdmin");
		ResponseObject response = new ResponseObject();
		response.code = 0;
		response.msg = null;
		response.body = adminService.getAdmins();
		
		return response;
	}
}
