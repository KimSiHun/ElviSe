package com.project.myprecious.elvis.myprecious.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.AttributeSet;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;
import com.project.myprecious.elvis.myprecious.R;
import com.project.myprecious.elvis.myprecious.beans.Event;

import java.util.ArrayList;

public class EnterQrPage extends HttpQRCodeInfoReaderView<ArrayList<Event>>{

        public EnterQrPage(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public EnterQrPage(Context context) {
            super(context);
        }

        @Override
        protected void dispatchInfoRead(String http, ArrayList<Event> model) {
            super.dispatchInfoRead(http, model);
        }
    }
