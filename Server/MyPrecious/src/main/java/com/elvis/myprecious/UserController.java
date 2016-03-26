package com.elvis.myprecious;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elvis.myprecious.model.ResponseObject;
import com.elvis.myprecious.model.User;
import com.elvis.myprecious.service.UserService;

@Controller
public class UserController {

	Logger logger = Logger.getLogger(UserController.class.getSimpleName());

	@Autowired
	UserService userService;

	@RequestMapping(value = "/av/events/{e_no}/users", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseObject insertUser(@RequestBody User user, @PathVariable("e_no") int e_no) throws Exception {
		// TODO 중복처리해야됨
		logger.info("insertUser");

		user.setU_e_no(e_no);

		ResponseObject response = new ResponseObject();
		if (userService.insertUser(user) == 1) {
			response.code = 0;
			response.msg = "신규유저 추가되었습니다.";
		} else {
			response.code = 1;
			response.msg = "이미 있는 유저입니다.";
		}
		return response;

	}

	@RequestMapping(value = "/av/events/{e_no}/users/{u_phonenumber}")
	@ResponseBody
	public ResponseObject loginUser(@PathVariable("e_no") int e_no, @PathVariable("u_phonenumber") String u_phonenumber) {
		
		User user = new User(0, u_phonenumber, e_no);
		
		logger.info(".selectUser");
		
		ResponseObject response = new ResponseObject();
		response.code = 0;
		response.msg = "null";
		response.body = userService.loginUser(user);
		return response;
	}
}
