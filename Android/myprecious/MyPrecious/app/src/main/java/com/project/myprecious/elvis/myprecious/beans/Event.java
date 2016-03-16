package com.project.myprecious.elvis.myprecious.beans;

public class Event {
    private int e_no;
    private String e_name;
    private String e_startTime;
    private String e_endTime;
    private int e_peopleCnt;

    public int getE_no() {
        return e_no;
    }

    public void setE_no(int e_no) {
        this.e_no = e_no;
    }

    public String getE_startTime() {
        return e_startTime;
    }

    public void setE_startTime(String e_startTime) {
        this.e_startTime = e_startTime;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_endTime() {
        return e_endTime;
    }

    public void setE_endTime(String e_endTime) {
        this.e_endTime = e_endTime;
    }

    public int getE_peopleCnt() {
        return e_peopleCnt;
    }

    public void setE_peopleCnt(int e_peopleCnt) {
        this.e_peopleCnt = e_peopleCnt;
    }
}
