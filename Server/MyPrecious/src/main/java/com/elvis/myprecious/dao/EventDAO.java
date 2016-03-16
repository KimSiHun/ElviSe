package com.elvis.myprecious.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.elvis.myprecious.model.Event;

@Repository
public class EventDAO {
	
	private static final String MAPPER_NS = "com.elvis.myprecious.dao.EventMapper";
	
	@Autowired
	SqlSession sqlSession;
	
	public List<Event> getEvent(int adminId){
		return sqlSession.selectList(MAPPER_NS + ".getEvent", adminId);
	}
}
