package com.project.myprecious.elvis.myprecious.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class Event implements Parcelable{
    private int e_no;
    private String e_name;
    private String e_starttime;
    private String e_endtime;
    private int e_peoplecnt;

    protected Event(Parcel in) {
        e_no = in.readInt();
        e_name = in.readString();
        e_starttime = in.readString();
        e_endtime = in.readString();
        e_peoplecnt = in.readInt();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public int getE_no() {
        return e_no;
    }

    public void setE_no(int e_no) {
        this.e_no = e_no;
    }

    public String getE_starttime() {
        return e_starttime;
    }

    public void setE_starttime(String e_starttime) {
        this.e_starttime = e_starttime;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_endtime() {
        return e_endtime;
    }

    public void setE_endtime(String e_endtime) {
        this.e_endtime = e_endtime;
    }

    public int getE_peoplecnt() {
        return e_peoplecnt;
    }

    public void setE_peoplecnt(int e_peoplecnt) {
        this.e_peoplecnt = e_peoplecnt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(e_no);
        dest.writeString(e_name);
        dest.writeString(e_starttime);
        dest.writeString(e_endtime);
        dest.writeInt(e_peoplecnt);
    }
}
