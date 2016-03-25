package com.project.myprecious.elvis.myprecious;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.project.myprecious.elvis.myprecious.beans.Event;
import com.project.myprecious.elvis.myprecious.beans.ResponseBody;
import com.project.myprecious.elvis.myprecious.widget.EventHttpQRCodeReaderView;
import com.project.myprecious.elvis.myprecious.widget.HttpQRCodeInfoReaderView;

import java.util.ArrayList;

public class QrCodeActivity extends AppCompatActivity {
    private EventHttpQRCodeReaderView mQrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);


        mQrCode = (EventHttpQRCodeReaderView) findViewById(R.id.qr_code_view);
        mQrCode.show();
        mQrCode.setOnHttpQRCodeReadListener(new HttpQRCodeInfoReaderView.OnHttpQRCodeInfoListener<ResponseBody<ArrayList<Event>>>() {
            @Override
            public void onHttpQRInfoReadCompleted(String uri, ResponseBody<ArrayList<Event>> info) {
//                Toast.makeText(QrCodeActivity.this, "url - " + uri, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onHttpQRInfoReadError(String uri) {
//                Toast.makeText(QrCodeActivity.this, "error to read qr code", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mQrCode.stop();
    }
}
