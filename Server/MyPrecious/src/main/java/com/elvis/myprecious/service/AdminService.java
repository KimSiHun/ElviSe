package com.elvis.myprecious.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvis.myprecious.dao.AdminDAO;
import com.elvis.myprecious.model.Admin;

@Service
public class AdminService {

	@Autowired
	AdminDAO adminDAO;
	
	public List<Admin> getAdmins(){
		return adminDAO.getAdmin();
	}
}
