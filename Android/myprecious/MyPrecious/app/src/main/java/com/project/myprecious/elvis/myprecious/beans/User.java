package com.project.myprecious.elvis.myprecious.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private int u_no;
    private String u_phonenumber;
    private int u_e_no;

    //Parcelable : 페이지 이동할 때 이전 페이지에 썼던 값 넘기려고 쓴거.
    // 나중에 보물 찾은 사람핸드폰 번호를 다시 서버에 넘겨야 할 거 같아서 써뒀음. 필요없으면 지우기

    @Override
    public String toString() {
        return "u_no - " + u_no + ", u_phonenumber - " + u_phonenumber;
    }

    public User(String u_phonenumber) {
        this.u_phonenumber = u_phonenumber;
    }

    protected User(Parcel in) {
        u_no = in.readInt();
        u_phonenumber = in.readString();
        u_e_no = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(u_no);
        dest.writeString(u_phonenumber);
        dest.writeInt(u_e_no);
    }
}
