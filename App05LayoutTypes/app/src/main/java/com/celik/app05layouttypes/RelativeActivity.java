package com.celik.app05layouttypes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class RelativeActivity extends AppCompatActivity {

    Button buttonColorize;
    Button buttonLoadImage;
    RelativeLayout relativeLayout;
    ImageView imageViewImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);

        relativeLayout = findViewById(R.id.relative_layout);
        buttonColorize = findViewById(R.id.button_colorize);
        buttonLoadImage = findViewById(R.id.button_load_image);
        imageViewImage = findViewById(R.id.image_view_image);

    }

    public void colorize(View view) {
        relativeLayout.setBackgroundColor(Color.BLUE);
    }

    public void loadImage(View view) {
        imageViewImage.setImageResource(R.drawable.ic_launcher_foreground);
    }
}