package com.celik.app26odev11fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnAndroidVersionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    @Override
    public void onSetAndroidVersionData(String name, String versionNo, String apiNo) {

        //Detail fragmente veri gönderme(set etme)
        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_detail);
        detailFragment.setData(name,versionNo,apiNo);
    }
}