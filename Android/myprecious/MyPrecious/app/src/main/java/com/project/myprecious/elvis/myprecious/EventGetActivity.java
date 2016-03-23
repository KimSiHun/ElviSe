package com.project.myprecious.elvis.myprecious;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.project.myprecious.elvis.myprecious.beans.Event;
import com.project.myprecious.elvis.myprecious.widget.EnterQrPage;
import com.project.myprecious.elvis.myprecious.widget.HttpQRCodeInfoReaderView;

import java.util.ArrayList;

public class EventGetActivity extends Activity {
    private EnterQrPage mQrCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_enterqr);
//
//        mQrCode=(EnterQrPage)findViewById(R.id.qr_code_view);
//        mQrCode.setOnHttpQRCodeReadListener(
//                new HttpQRCodeInfoReaderView.OnHttpQRCodeInfoListener<ArrayList<Event>>() {
//                    @Override
//                    public void onHttpQRInfoReadCompleted(String uri, ArrayList<Event> info) {
//                    Toast.makeText(EventGetActivity.this, "url - " + uri, Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onHttpQRInfoReadError(String uri) {
//                        Toast.makeText(EventGetActivity.this, "error to read qr code", Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );
    }
}
