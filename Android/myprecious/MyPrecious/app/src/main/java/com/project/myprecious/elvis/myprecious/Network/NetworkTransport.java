package com.project.myprecious.elvis.myprecious.Network;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.project.myprecious.elvis.myprecious.beans.User;

import java.util.ArrayList;

public class NetworkTransport {
    private static ArrayList<User> mUser = new ArrayList<>();
    private static Handler mHandler = new Handler(Looper.getMainLooper());
    private static NetworkTransport instance = new NetworkTransport();
    private static int id = 0;

    private NetworkTransport() {
        //TODO add test User. 나중에 지우기
        createUser(new User());
    }
    public static NetworkTransport getInstance() {
        return instance;
    }
    public void createUser(User user){
        user.setU_no(id++);
        mUser.add(user);
    }

    public interface NetworkTransportCallback<T> {
        void onSuccess(ArrayList<T> result);
        void onFailure();
    }
}
