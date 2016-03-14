package com.project.myprecious.elvis.myprecious;

import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;

public class EnterQrPage extends Activity implements QRCodeReaderView.OnQRCodeReadListener {
    private QRCodeReaderView qr_code_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_enterqr);
        qr_code_view=(QRCodeReaderView) findViewById(R.id.qr_code_view);
        qr_code_view.setOnQRCodeReadListener(this);
    }

    @Override
    public void onQRCodeRead(String text, PointF[] points) {

    }

    @Override
    public void cameraNotFound() {

    }

    @Override
    public void QRCodeNotFoundOnCamImage() {

    }

}
