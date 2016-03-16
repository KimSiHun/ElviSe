package com.project.myprecious.elvis.myprecious;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.project.myprecious.elvis.myprecious.Network.NetworkTransport;
import com.project.myprecious.elvis.myprecious.beans.User;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements NetworkTransport.NetworkTransportCallback<User>{

    private UserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button enterBtn = (Button) findViewById(R.id.enterBtn);
        final EditText phoneNumber = (EditText) findViewById(R.id.phoneText);
        Button goBtn1 = (Button) findViewById(R.id.goSangmin);
        Button goBtn2 = (Button) findViewById(R.id.goGoohyun);

        //TODO, 임시버튼임. QR 찍으면 다음페이지로 넘어가게 구성
        goBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PreciousOpen.class);
                startActivity(intent);
            }
        });

        //TODO, 임시버튼2
        goBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PreciousResult.class);
                startActivity(intent);
            }
        });

        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EnterQrPage.class);
                isValidCellPhoneNumber(String.valueOf(phoneNumber));
                startActivity(intent);
            }
        });


    }

    //
//    public boolean inCellphoneOK(String phoneNumber){
//        return phoneNumber.matches("(01[016789])-(||d{3,4})-(||d{4})");
//    }
    public static boolean isValidCellPhoneNumber(String phoneNumber) {
        boolean returnValue = false;
        Log.i("cell", phoneNumber);
        String regex = "^\\s*(010|011|012|013|014|015|016|017|018|019)(-|\\)|\\s)*(\\d{3,4})(-|\\s)*(\\d{4})\\s*$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phoneNumber);
        if (m.matches()) {
            returnValue = true;
        }
        return returnValue;
    }

    @Override
    public void onSuccess(ArrayList<User> result) {
    }

    @Override
    public void onFailure() {
    }

    private class UserAdapter {
    }
}
