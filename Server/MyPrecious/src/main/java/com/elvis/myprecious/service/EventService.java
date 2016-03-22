package com.elvis.myprecious.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvis.myprecious.dao.EventDAO;
import com.elvis.myprecious.model.Event;

@Service
public class EventService {
	
	@Autowired
	EventDAO eventDAO;
	
	public List<Event> getEvents(int adminId){
		return eventDAO.getEvent(adminId);
	}
	
	public int insertEvents(Event event) {
		return eventDAO.insertEvent(event);
	}
	
	public int editEvents(Event event) {
		return eventDAO.editEvent(event);
	}
	
	public int deleteEvents(int e_no){
		return eventDAO.deleteEvent(e_no);
	}
}
