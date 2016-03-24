package com.project.myprecious.elvis.myprecious.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.project.myprecious.elvis.myprecious.beans.Event;
import com.project.myprecious.elvis.myprecious.beans.ResponseBody;

import java.util.ArrayList;

public class EventHttpQRCodeReaderView extends HttpQRCodeInfoReaderView<ResponseBody<ArrayList<Event>>> {

    public EventHttpQRCodeReaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EventHttpQRCodeReaderView(Context context) {
        super(context);
    }

    @Override
    protected void dispatchInfoRead(String http, ResponseBody<ArrayList<Event>> model) {
        super.dispatchInfoRead(http, model);
    }
}
