package com.project.myprecious.elvis.myprecious.beans;

public class User {
    private int u_no;
    private String u_phoneNumber;

    public User(String u_phoneNumber) {
        this.u_phoneNumber = u_phoneNumber;
    }

    public int getU_no() {
        return u_no;
    }

    public void setU_no(int u_no) {
        this.u_no = u_no;
    }

    public String getU_phoneNumber() {
        return u_phoneNumber;
    }

    public void setU_phoneNumber(String u_phoneNumber) {
        this.u_phoneNumber = u_phoneNumber;
    }
}
