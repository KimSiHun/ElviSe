package com.project.myprecious.elvis.myprecious;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.myprecious.elvis.myprecious.Network.NetworkTransport;
import com.project.myprecious.elvis.myprecious.beans.Event;
import com.project.myprecious.elvis.myprecious.beans.ResponseBody;
import com.project.myprecious.elvis.myprecious.beans.User;
import com.project.myprecious.elvis.myprecious.widget.EventHttpQRCodeReaderView;
import com.project.myprecious.elvis.myprecious.widget.HttpQRCodeInfoReaderView;

import java.util.ArrayList;

public class UserJoinActivity extends AppCompatActivity implements NetworkTransport.NetworkTransportCallback<User> {
    private EditText mPhoneNumber;
    private Button joinOk;
    //TODO Event e_no는 임시값으로 써둠. 나중에 event get 해서 처리하기
    private int e_no = 3;
    private User user;
    private EventHttpQRCodeReaderView mQrCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);


        mQrCode = (EventHttpQRCodeReaderView) findViewById(R.id.qr_code_view);
        mQrCode.show();
        mQrCode.setOnHttpQRCodeReadListener(new HttpQRCodeInfoReaderView.OnHttpQRCodeInfoListener<ResponseBody<ArrayList<Event>>>() {
            @Override
            public void onHttpQRInfoReadCompleted(String uri, ResponseBody<ArrayList<Event>> info) {
//                Toast.makeText(UserJoinActivity.this, "url - " + uri, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onHttpQRInfoReadError(String uri) {
//                Toast.makeText(UserJoinActivity.this, "error to read qr code", Toast.LENGTH_SHORT).show();
            }
        });


        mPhoneNumber = (EditText) findViewById(R.id.phoneText);

        joinOk = (Button) findViewById(R.id.joinOk);
        joinOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phonenumber = mPhoneNumber.getText().toString();
                user = new User(phonenumber);
                NetworkTransport.getInstance().createUser(e_no, user, new NetworkTransport.NetworkTransportCallback() {
                    @Override
                    public void onSuccess(ArrayList result) {
                        Toast.makeText(UserJoinActivity.this, "등록 되었습니다", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure() {
                        Toast.makeText(UserJoinActivity.this, "다시 시도해주세요", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mQrCode.stop();
    }

    @Override
    public void onSuccess(ArrayList<User> result) {

    }

    @Override
    public void onFailure() {

    }
}
