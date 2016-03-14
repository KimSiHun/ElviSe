package com.elvis.myprecious.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.elvis.myprecious.model.Admin;

@Repository
public class AdminDAO {

		private static final String MAPPER_NS = "com.elvis.myprecious.dao.AdminMapper";

		@Autowired
		SqlSession sqlSession;
		
		public List<Admin> getAdmin(){
			return sqlSession.selectList(MAPPER_NS + ".getAdmin"); 
		}
}
