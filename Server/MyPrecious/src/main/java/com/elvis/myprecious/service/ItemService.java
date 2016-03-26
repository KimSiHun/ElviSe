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
	
	public int editItems(Item item) {
		return itemDAO.editItem(item);
	}
	
	public int deleteItems(int i_no) {
		return itemDAO.deleteItem(i_no);
	}
	
	public List<Item> getItem2s(int i_e_no){
		return itemDAO.getItem2(i_e_no);
	}
	
	public int editItem2s(Item item) {
		return itemDAO.editItem2(item);
	}
}
