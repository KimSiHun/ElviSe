package com.elvis.myprecious.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.elvis.myprecious.model.User;

@Repository
public class UserDAO {
	private static final String MAPPER_NS = "com.elvis.myprecious.dao.UserMapper";
	@Autowired
	SqlSession sqlSession;

	// user 등록 DB에
	public int insertUser(User user) {

		return sqlSession.update(MAPPER_NS + ".insertUser", user);
	}
}
