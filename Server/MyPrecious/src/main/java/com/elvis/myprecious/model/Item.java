package com.elvis.myprecious.model;

public class Item {
	private int i_no;
	private String i_name;
	private String i_img;
	private String i_e_name;
	private String i_getTime;

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(int i_no, String i_name, String i_img, String i_e_name, String i_getTime) {
		super();
		this.i_no = i_no;
		this.i_name = i_name;
		this.i_img = i_img;
		this.i_e_name = i_e_name;
		this.i_getTime = i_getTime;
	}

	public int getI_no() {
		return i_no;
	}

	public void setI_no(int i_no) {
		this.i_no = i_no;
	}

	public String getI_name() {
		return i_name;
	}

	public void setI_name(String i_name) {
		this.i_name = i_name;
	}

	public String getI_img() {
		return i_img;
	}

	public void setI_img(String i_img) {
		this.i_img = i_img;
	}

	public String getI_e_name() {
		return i_e_name;
	}

	public void setI_e_name(String i_e_name) {
		this.i_e_name = i_e_name;
	}

	public String getI_getTime() {
		return i_getTime;
	}

	public void setI_getTime(String i_getTime) {
		this.i_getTime = i_getTime;
	}

}
