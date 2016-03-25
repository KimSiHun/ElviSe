package com.elvis.myprecious.model;

public class Item {
	private int i_no;
	private String i_name;
	private String i_img;
	private int i_e_no;
	private String i_gettime;

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(int i_no, String i_name, String i_img, int i_e_no, String i_gettime) {
		super();
		this.i_no = i_no;
		this.i_name = i_name;
		this.i_img = i_img;
		this.i_e_no = i_e_no;
		this.i_gettime = i_gettime;
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

	public int getI_e_no() {
		return i_e_no;
	}

	public void setI_e_no(int i_e_no) {
		this.i_e_no = i_e_no;
	}

	public String getI_gettime() {
		return i_gettime;
	}

	public void setI_gettime(String i_gettime) {
		this.i_gettime = i_gettime;
	}

	


}
