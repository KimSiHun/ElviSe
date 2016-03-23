package com.project.myprecious.elvis.myprecious;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by SangMin on 2016-03-17.
 */
public class PresetnItemView extends LinearLayout {
    TextView name;

    public PresetnItemView(Context context) {
        super(context);
        init(context);
    }

    public PresetnItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.present_item, this, true);
        name = (TextView) findViewById(R.id.name);
    }

    public void setName(String names) {
        name.setText(names);
    }


}
