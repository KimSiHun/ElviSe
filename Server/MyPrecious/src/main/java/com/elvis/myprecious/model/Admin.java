package com.elvis.myprecious.model;

public class Admin {
	private int a_id;
	private String a_pw;
	private String a_company;
	private String a_name;

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(int a_id, String a_pw, String a_company, String a_name) {
		super();
		this.a_id = a_id;
		this.a_pw = a_pw;
		this.a_company = a_company;
		this.a_name = a_name;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getA_pw() {
		return a_pw;
	}

	public void setA_pw(String a_pw) {
		this.a_pw = a_pw;
	}

	public String getA_company() {
		return a_company;
	}

	public void setA_company(String a_company) {
		this.a_company = a_company;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

}
