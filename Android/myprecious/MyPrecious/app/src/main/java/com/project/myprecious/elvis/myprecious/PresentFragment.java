package com.project.myprecious.elvis.myprecious;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * Created by SangMin on 2016-03-16.
 */
public class PresentFragment extends Fragment {
    ListView presentListView;
    PresentListAdapter presentListAdapter;


    private static final String ARG_SECTION_NUMBER = "section_number";

    public static PresentFragment newinstance(int sectionNumber) {
     PresentFragment fragment = new PresentFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PresentFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_info_present,container,false);
        presentListView = (ListView) rootView.findViewById(R.id.presentListView);
        presentListAdapter = new PresentListAdapter();
        presentListView.setAdapter(presentListAdapter);
        return rootView;
    }


    // 상품정보 리스트 어댑터 (따로 클래스 만드니깐 Context 생성이 안되서 그냥 inner Class로 만듦)
    public class PresentListAdapter extends BaseAdapter {
        String[] names = {"맥북에어", "아이패드", "외장하드", "로지텍마우스", "USB", "메모지"};

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            PresetnItemView view = new PresetnItemView(getContext());
            view.setName(names[position]);
            return view;
        }


    }



}
