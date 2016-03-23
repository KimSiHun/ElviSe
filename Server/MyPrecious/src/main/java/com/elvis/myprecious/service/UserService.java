package com.elvis.myprecious.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvis.myprecious.dao.UserDAO;
import com.elvis.myprecious.model.User;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;
	
	public int insertUser(User user) {
		return userDAO.insertUser(user);
	}
}
