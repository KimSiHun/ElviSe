package com.project.myprecious.elvis.myprecious.beans;


/**
 * this value should be same with server interface <br>
 * @param <T>
 */
public class ResponseBody<T> {
    public int code;
    public String msg;
    public T body;

    @Override
    public String toString() {
        return "code - " + code + ", msg - " + msg  + ", body - " + body;
    }
}
