package com.elvis.myprecious.model;

public class User {
	private int u_no;
	private String u_phonenumber;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int u_no, String u_phonenumber) {
		super();
		this.u_no = u_no;
		this.u_phonenumber = u_phonenumber;
	}

	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
	}

	public String getU_phonenumber() {
		return u_phonenumber;
	}

	public void setU_phonenumber(String u_phonenumber) {
		this.u_phonenumber = u_phonenumber;
	}

}
