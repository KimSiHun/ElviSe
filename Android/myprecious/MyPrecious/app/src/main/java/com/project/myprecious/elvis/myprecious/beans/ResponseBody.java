package com.project.myprecious.elvis.myprecious.beans;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * this value should be same with server interface <br>
 * @param <T>
 */
public class ResponseBody<T> {
    public int code;
    public String msg;
    public T body;

    @SerializedName("users")
    public List<User> users;

    @Override
    public String toString() {
        return "code - " + code + ", msg - " + msg  + ", body - " + body;
    }
}
