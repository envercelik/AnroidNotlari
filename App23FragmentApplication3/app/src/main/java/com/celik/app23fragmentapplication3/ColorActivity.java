package com.celik.app23fragmentapplication3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;

public class ColorActivity extends AppCompatActivity implements OnColorChangeListener{

    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ColorFragment colorFragment = new ColorFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.color_container,colorFragment).commit();

        constraintLayout = findViewById(R.id.constraint_layout);
    }



    @Override
    public void onColorChanged(int color) {
        constraintLayout.setBackgroundColor(color);
    }
}