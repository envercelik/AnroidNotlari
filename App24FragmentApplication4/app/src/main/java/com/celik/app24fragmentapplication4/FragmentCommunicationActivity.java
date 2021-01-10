package com.celik.app24fragmentapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FragmentCommunicationActivity extends AppCompatActivity implements OnSetNameListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public void onSetName(String name) {

       //static fragmente veri gönderme
       ReceiverFragment receiverFragment =(ReceiverFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_reciever);
       receiverFragment.setName(name);

    }
}