package com.celik.app21fragmentapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    ListView listViewAndroidVersion;

    String[] androidVersions;

    ArrayAdapter<String> arrayAdapter;


    public ListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        listViewAndroidVersion = view.findViewById(R.id.list_view_android_version);
        androidVersions = getResources().getStringArray(R.array.AndroidRelease);
        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,androidVersions);

        listViewAndroidVersion.setAdapter(arrayAdapter);

        // Inflate the layout for this fragment
        return view;
    }
}