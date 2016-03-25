package com.elvis.myprecious.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.elvis.myprecious.dao.UserDAO;
import com.elvis.myprecious.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private DataSourceTransactionManager dstm;

	@Transactional
	public int insertUser(User user) throws Exception{
		DefaultTransactionDefinition dtd = new DefaultTransactionDefinition();
		dtd.setName("insert-user-transaction");
		dtd.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		// 성공여부를 위한 flag
		int commitFlag = 0;
		TransactionStatus status = dstm.getTransaction(dtd);
		
		try {
			List<User> userList = userDAO.selectUser();
			
			for (User user2 : userList) {
				// 중복값이 있으면 멈춘다.
				if (user.getU_phonenumber().equals(user2.getU_phonenumber())) {
					commitFlag = 0;
					break;
					// 중복 값이 없으면 flag를 1로 하고 계속 돌림
				}else if(!user.getU_phonenumber().equals(user2.getU_phonenumber())){
					commitFlag = 1;
				}
			}
			
			if (commitFlag == 1) {
				userDAO.insertUser(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
			dstm.rollback(status);
		}
		
		dstm.commit(status);
		return commitFlag;
	}
	
	
	public List<User> loginUser(User user) {
		
		return userDAO.loginUser(user);
	}
}
