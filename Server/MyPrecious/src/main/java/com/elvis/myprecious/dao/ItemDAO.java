package com.elvis.myprecious.dao;

import java.util.HashMap;
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
	
	public List<Item> getItem(int adminId, int i_e_no) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("adminId", adminId);
		map.put("i_e_no", i_e_no);
		return sqlSession.selectList(MAPPER_NS+".getItem", map);
	}
	
	public int insertItem(Item item) {
		return sqlSession.insert(MAPPER_NS + ".insertItem", item);
	}
	
	public int editItem(Item item) {
		return sqlSession.update(MAPPER_NS + ".editItem", item);
	}
	
	public int deleteItem(int i_no) {
		return sqlSession.delete(MAPPER_NS + ".deleteItem", i_no);
	}
	
	public List<Item> getItem2(int i_e_no) {
		return sqlSession.selectList(MAPPER_NS + ".getItem2", i_e_no);
	}
	
}
