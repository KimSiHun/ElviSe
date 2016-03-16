package com.elvis.myprecious.model;

public class Event {
	private int e_no;
	private String e_name;
	private String e_starttime;
	private String a_endtime;
	private int e_peoplecnt;
	private int adminId;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(int e_no, String e_name, String e_starttime, String a_endtime, int e_peoplecnt, int adminId) {
		super();
		this.e_no = e_no;
		this.e_name = e_name;
		this.e_starttime = e_starttime;
		this.a_endtime = a_endtime;
		this.e_peoplecnt = e_peoplecnt;
		this.adminId = adminId;
	}

	public int getE_no() {
		return e_no;
	}

	public void setE_no(int e_no) {
		this.e_no = e_no;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getE_starttime() {
		return e_starttime;
	}

	public void setE_starttime(String e_starttime) {
		this.e_starttime = e_starttime;
	}

	public String getA_endtime() {
		return a_endtime;
	}

	public void setA_endtime(String a_endtime) {
		this.a_endtime = a_endtime;
	}

	public int getE_peoplecnt() {
		return e_peoplecnt;
	}

	public void setE_peoplecnt(int e_peoplecnt) {
		this.e_peoplecnt = e_peoplecnt;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	
	
	

}
