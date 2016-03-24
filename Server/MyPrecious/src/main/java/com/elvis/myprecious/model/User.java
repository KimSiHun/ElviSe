package com.elvis.myprecious.model;

public class User {
	private int u_no;
	private String u_phonenumber;
	private int u_e_no;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int u_no, String u_phonenumber, int u_e_no) {
		super();
		this.u_no = u_no;
		this.u_phonenumber = u_phonenumber;
		this.u_e_no = u_e_no;
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

	public int getU_e_no() {
		return u_e_no;
	}

	public void setU_e_no(int u_e_no) {
		this.u_e_no = u_e_no;
	}

	
}
