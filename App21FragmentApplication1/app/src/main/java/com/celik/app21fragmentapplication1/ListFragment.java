package com.celik.app21fragmentapplication1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment extends Fragment {

    ListView listViewAndroidVersion;



    public ListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View fragmentList = inflater.inflate(R.layout.fragment_list, container, false);
        listViewAndroidVersion = fragmentList.findViewById(R.id.list_view_android_version);

        String[] androidVersions = getResources().getStringArray(R.array.androidVersions);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,androidVersions);
        listViewAndroidVersion.setAdapter(arrayAdapter);

        return fragmentList;
    }
}