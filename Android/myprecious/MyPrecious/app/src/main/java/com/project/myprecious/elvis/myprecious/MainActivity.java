package com.project.myprecious.elvis.myprecious;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO, 임시버튼임. QR 찍으면 다음페이지로 넘어가게 구성
        Button goBtn1 = (Button)findViewById(R.id.goSangmin);
        goBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PreciousOpen.class);
                startActivity(intent);
            }
        });

        //TODO, 임시버튼2
        Button goBtn2 = (Button)findViewById(R.id.goGoohyun);
        goBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PreciousResult.class);
                startActivity(intent);
            }
        });

        Button enterBtn = (Button)findViewById(R.id.enterBtn);
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,EnterQrPage.class);
                startActivity(intent);
            }
        });
    }
}
