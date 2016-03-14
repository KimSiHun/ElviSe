package com.elvis.myprecious.model;

public class ResponseObject {
	public int code;
	public String msg;
	public Object body;

	public ResponseObject() {
		// TODO Auto-generated constructor stub
	}

	public ResponseObject(int code, String msg, Object body) {
		super();
		this.code = code;
		this.msg = msg;
		this.body = body;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

}
