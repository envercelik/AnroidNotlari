package com.celik.app25fragmentapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FragmentCommunicationActivity extends AppCompatActivity implements OnNameSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_communication);
    }


    @Override
    public void onSetName(String name) {

        //dinamik olarak oluşturulan fragmente veri gönderme
        ReceiverFragment receiverFragment=ReceiverFragment.newInstance(name);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,receiverFragment).commit();

    }
}