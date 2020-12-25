package com.celik.app05layouttypes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void linearActivity(View view) {
        Intent intent = new Intent(MainActivity.this, LinearActivity.class);
        startActivity(intent);
    }

    public void relativeActivity(View view) {
        Intent intent = new Intent(MainActivity.this, RelativeActivity.class);
        startActivity(intent);
    }


    public void frameActivity(View view) {
        Intent intent = new Intent(MainActivity.this, FrameActivity.class);
        startActivity(intent);
    }


    public void gridActivity(View view) {
        Intent intent = new Intent(MainActivity.this, GridActivity.class);
        startActivity(intent);
    }


    public void tableActivity(View view) {
        Intent intent = new Intent(MainActivity.this, TableActivity.class);
        startActivity(intent);
    }



}