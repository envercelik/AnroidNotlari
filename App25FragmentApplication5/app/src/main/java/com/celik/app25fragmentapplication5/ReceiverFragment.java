package com.celik.app25fragmentapplication5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ReceiverFragment extends Fragment {

    String name;
    TextView tvName;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ReceiverFragment() {
        // Required empty public constructor
    }


    public static ReceiverFragment newInstance(String name) {
        ReceiverFragment fragment = new ReceiverFragment();
        Bundle args = new Bundle();
        args.putString("name", name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString("name");

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View receiverFragment = inflater.inflate(R.layout.fragment_receiver, container, false);
        tvName = receiverFragment.findViewById(R.id.tv_name);
        tvName.setText(name);

        return receiverFragment;
    }
}