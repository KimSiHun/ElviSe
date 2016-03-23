package com.project.myprecious.elvis.myprecious;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PreciousResult extends AppCompatActivity {

    boolean getYourQrcode = false;
    TextView tv1,tv2,tv3,tv4;
    ImageView iv;
    Drawable defaultIv, successIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_precious_result);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        iv = (ImageView) findViewById(R.id.image_fail);
        tv1 = (TextView) findViewById(R.id.text_productName1);
        tv2 = (TextView) findViewById(R.id.text_productName2);
        tv3 = (TextView) findViewById(R.id.text_spot1);
        tv4 = (TextView) findViewById(R.id.text_spot2);

        defaultIv = getResources().getDrawable(R.drawable.back_button);
        successIv = getResources().getDrawable(R.drawable.tiger);

        YesorNo(true);
    }

    public void YesorNo(boolean getYourQrcode){

        if(getYourQrcode == false){
            iv.setImageDrawable(defaultIv);

        }else if(getYourQrcode == true){
            iv.setImageDrawable(successIv);

            tv1.setText("상품명 :");
            tv2.setText("타바코");
            tv3.setText("상품 수령장소");
            tv4.setText("가남초등학교로 오세요");
       }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
