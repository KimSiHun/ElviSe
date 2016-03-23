package com.project.myprecious.elvis.myprecious;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by SangMin on 2016-03-16.
 */
public class StatusFragment extends Fragment{
    private static final String ARG_SECTION_NUMBER = "section_number";

    public static StatusFragment newinstance(int sectionNumber) {
     StatusFragment fragment = new StatusFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public StatusFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_info_status,container,false);
        return rootView;
    }
}
