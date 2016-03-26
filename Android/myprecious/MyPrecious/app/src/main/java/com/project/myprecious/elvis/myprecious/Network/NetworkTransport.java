package com.project.myprecious.elvis.myprecious.Network;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.project.myprecious.elvis.myprecious.beans.Event;
import com.project.myprecious.elvis.myprecious.beans.ResponseBody;
import com.project.myprecious.elvis.myprecious.beans.User;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkTransport {

    private static final String LOG_TAG = NetworkTransport.class.getSimpleName();
    private static HashMap<Integer, HashMap<String, ArrayList<User>>> mEventUser = new HashMap<>();

    private static ArrayList<Event> mEvent = new ArrayList<>();
    private static ArrayList<User> mUser = new ArrayList<>();
    private static Handler mHandler = new Handler(Looper.getMainLooper());
    private static NetworkTransport instance = new NetworkTransport();

    private static final String SERVER_URL = "http://52.79.126.74:8080/";
    private Retrofit retrofit;
    private ProjectApiService mService;

    private NetworkTransport() {
        init();
    }

    //웹 서버 연결
    private void init() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mService = retrofit.create(ProjectApiService.class);
    }


    public static NetworkTransport getInstance() {
        return instance;
    }

    public void createUser(int e_no, User user, final NetworkTransportCallback callback) {
        mService.createUser(e_no, user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(LOG_TAG, "createUser.onResponse");
                if (callback != null) {
                    mUser.add(response.body());
                    callback.onSuccess(mUser);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(LOG_TAG, "createUser.onFailure", t);
            }
        });
    }

    public void getUser(final int e_no, final String phonenumber, final NetworkTransportCallback callback) {
        Log.e(LOG_TAG, "getUser");
        mService.getUser(e_no, phonenumber).enqueue(new Callback<ResponseBody<ArrayList<User>>>() {
            @Override
            public void onResponse(Call<ResponseBody<ArrayList<User>>> call, Response<ResponseBody<ArrayList<User>>> response) {
                if(callback!=null){
                    Log.e(LOG_TAG, "getUser.onResponse");
                    ArrayList<User> users=getCachedUser(e_no,phonenumber);
                    callback.onSuccess(users);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody<ArrayList<User>>> call, Throwable t) {
                Log.e(LOG_TAG, "getUser.onFailure");
            }
        });
    }

    //Event e_no랑 User u_phonenumber랑 연관해서 쓰려고 해쉬맵 썼는데 딱히 안써도 됨......
    public ArrayList<User> getCachedUser(int e_no, String phonenumber) {
        HashMap<String, ArrayList<User>> event = mEventUser.get(e_no);
        if (event == null) {
            event = new HashMap<>();
            mEventUser.put(e_no, event);

        }
        ArrayList<User> user = event.get(phonenumber);
        if (user == null) {
            user = new ArrayList<User>();
            event.put(phonenumber, user);
        }
        return user;
    }


    public interface NetworkTransportCallback<T> {
        void onSuccess(ArrayList<T> result);

        void onFailure();
    }
}
