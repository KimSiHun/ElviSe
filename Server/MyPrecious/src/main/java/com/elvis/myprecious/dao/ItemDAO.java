package com.elvis.myprecious.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.elvis.myprecious.model.Item;

@Repository
public class ItemDAO {
	private static final String MAPPER_NS = "com.elvis.myprecious.dao.ItemMapper";
	
	@Autowired
	SqlSession sqlSession;
	
	public List<Item> getItem() {
		return sqlSession.selectList(MAPPER_NS+".getItem");
	}
	
	
}
