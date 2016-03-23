package com.elvis.myprecious;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elvis.myprecious.dao.UserDAO;
import com.elvis.myprecious.model.ResponseObject;
import com.elvis.myprecious.model.User;
import com.elvis.myprecious.service.UserService;

@Controller
public class UserController {
	
	Logger logger = Logger.getLogger(UserController.class.getSimpleName());
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="user/insert/", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public ResponseObject insertUser(@RequestBody User user) {
		// TODO 중복처리해야됨
		logger.info("insertUser");
		System.out.println(user.getU_phonenumber());
		ResponseObject response = new ResponseObject();
		response.code = 0;
		response.msg = null;
		response.body = userService.insertUser(user);
		return response;
		
	}
}
