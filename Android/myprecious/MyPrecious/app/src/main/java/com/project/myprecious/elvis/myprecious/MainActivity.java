package com.project.myprecious.elvis.myprecious;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.myprecious.elvis.myprecious.Network.NetworkTransport;
import com.project.myprecious.elvis.myprecious.beans.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NetworkTransport.NetworkTransportCallback<User> {

    //TODO Event e_no는 임시값으로 써둠. 나중에 event get 해서 처리하기
    private int e_no = 3;

    private User user;
    private EditText mPhoneNumber;
    private Button joinGo;
    private Button mEnterBtn;
    private Button goBtn1;
    private Button goBtn2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO, 임시버튼임. 상민오빠 다 썼으면 지워요
        goBtn1 = (Button) findViewById(R.id.goSangmin);
        goBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });

        //TODO, 임시버튼2
        goBtn2 = (Button) findViewById(R.id.goGoohyun);
        goBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PreciousResult.class);
                startActivity(intent);
            }
        });

        mPhoneNumber = (EditText) findViewById(R.id.phoneText);
        mEnterBtn = (Button) findViewById(R.id.enterBtn);
        mEnterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phonenumber= mPhoneNumber.getText().toString();
                NetworkTransport.getInstance().getUser(e_no,phonenumber, new NetworkTransport.NetworkTransportCallback() {
                    @Override
                    public void onSuccess(ArrayList result) {
                        Toast.makeText(MainActivity.this, "입장합니다", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure() {
                        Toast.makeText(MainActivity.this, "다시 시도해주세요", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        //TODO 가입하러 가기 버튼 액션바 위로 올렸으면 좋겠음......디자인.....
        joinGo = (Button) findViewById(R.id.joinGo);
        joinGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), UserJoinActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSuccess(ArrayList<User> result) {
    }

    @Override
    public void onFailure() {
    }


}
