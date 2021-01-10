package com.celik.app24fragmentapplication4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ReceiverFragment extends Fragment {

    TextView tvName;

    public ReceiverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View receiverFragment = inflater.inflate(R.layout.fragment_receiver, container, false);
        tvName = receiverFragment.findViewById(R.id.tv_name);

        return receiverFragment;
    }

    public void setName(String name) {
        tvName.setText(name);
    }
}