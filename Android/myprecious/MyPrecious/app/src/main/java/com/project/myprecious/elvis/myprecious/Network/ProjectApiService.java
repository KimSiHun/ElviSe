package com.project.myprecious.elvis.myprecious.Network;

import com.project.myprecious.elvis.myprecious.beans.ResponseBody;
import com.project.myprecious.elvis.myprecious.beans.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ProjectApiService {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json",
    })
    @POST("/myprecious/av/events/{e_no}/users")
    Call<User> createUser(@Path("e_no") int no,@Body User user);

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json",
    })
    @GET("/myprecious/av/events/{e_no}/users/{u_phonenumber}")
    Call<ResponseBody<ArrayList<User>>> getUser(@Path("e_no") int no,@Path("u_phonenumber") String phonenumber);

//    @Headers({
//            "Accept: application/json",
//            "Content-Type: application/json",
//    })
//    @GET("/myprecious/events/")
//    Call<Event> getEvent();

}
