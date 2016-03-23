package com.project.myprecious.elvis.myprecious;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.myprecious.elvis.myprecious.Network.NetworkTransport;
import com.project.myprecious.elvis.myprecious.beans.User;
import com.project.myprecious.elvis.myprecious.widget.EnterQrPage;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NetworkTransport.NetworkTransportCallback<User> {
    private User user;

    private EditText mPhoneNumber;
    private Button mEnterBtn;
    private Button goBtn1;
    private Button goBtn2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO, 임시버튼임. QR 찍으면 다음페이지로 넘어가게 구성
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
                String phonenumber =mPhoneNumber.getText().toString();
                user = new User(phonenumber);
                NetworkTransport.getInstance().createUser(user, new NetworkTransport.NetworkTransportCallback() {
                    @Override
                    public void onSuccess(ArrayList result) {
                        Intent intent = new Intent(MainActivity.this, EventGetActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure() {
                    Toast.makeText(MainActivity.this, "다시 시도해주세요", Toast.LENGTH_SHORT).show();
                    }
                });
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
