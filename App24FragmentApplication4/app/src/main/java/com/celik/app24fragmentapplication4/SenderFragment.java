package com.celik.app24fragmentapplication4;

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
    OnSetNameListener nameListener;
    EditText etName;
    Button btnSend;



    public SenderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View senderFragment = inflater.inflate(R.layout.fragment_sender, container, false);

        etName = senderFragment.findViewById(R.id.et_Name);

        btnSend = senderFragment.findViewById(R.id.btn_Send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                nameListener.onSetName(name);
            }
        });



        return senderFragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof FragmentCommunicationActivity) {
            nameListener = (OnSetNameListener) context;
        }
    }
}