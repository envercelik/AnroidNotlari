package com.celik.app05layouttypes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FrameActivity extends AppCompatActivity {

    ImageView imageView1;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        imageView1 = findViewById(R.id.image_view_1);
        imageView2 = findViewById(R.id.image_view_2);

    }

    public void visible(View view) {
        imageView1.setVisibility(View.VISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
    }
}