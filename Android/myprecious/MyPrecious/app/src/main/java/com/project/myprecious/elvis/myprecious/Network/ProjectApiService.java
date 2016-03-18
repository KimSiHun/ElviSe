package com.project.myprecious.elvis.myprecious.Network;

import com.project.myprecious.elvis.myprecious.beans.ResponseBody;
import com.project.myprecious.elvis.myprecious.beans.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ProjectApiService {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json",
    })
    @POST("myprecious/user/insert")
    Call<User> createUser(@Body User user);

}
