package com.celik.app26odev11fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailFragment extends Fragment {

    TextView textViewVersionName;
    TextView textViewVersionNo;
    TextView textViewApiNo;


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewFragmentDetail = inflater.inflate(R.layout.fragment_detail, container, false);

        textViewVersionName = viewFragmentDetail.findViewById(R.id.text_view_version_name);
        textViewVersionNo = viewFragmentDetail.findViewById(R.id.text_view_version_no);
        textViewApiNo = viewFragmentDetail.findViewById(R.id.text_view_api_no);

        return viewFragmentDetail;
    }


    public void setData(String name,String versionNo , String apiNo) {

        textViewVersionName.setText(name);
        textViewVersionNo.setText(versionNo);
        textViewApiNo.setText(apiNo);

    }

}