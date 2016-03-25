package com.elvis.myprecious.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elvis.myprecious.dao.ItemDAO;
import com.elvis.myprecious.model.Item;

@Service
public class ItemService {

	@Autowired
	ItemDAO itemDAO;
	
	public List<Item> getItems(int adminId, int i_e_no){
		return itemDAO.getItem(adminId, i_e_no);
	}
	
	public int insertItems(Item item) {
		return itemDAO.insertItem(item);
	}
}
