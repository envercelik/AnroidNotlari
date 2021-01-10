package com.celik.app25fragmentapplication5;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class SenderFragment extends Fragment {

    Button btnSend;
    EditText etName;
    OnNameSetListener nameSetListener;



    public SenderFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_sender, container, false);
        btnSend=view.findViewById(R.id.btn_Send);
        etName=view.findViewById(R.id.et_Name);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=etName.getText().toString();
                nameSetListener.onSetName(name);

            }
        });
        return view;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnNameSetListener) {
            nameSetListener = (OnNameSetListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        nameSetListener = null;
    }
}