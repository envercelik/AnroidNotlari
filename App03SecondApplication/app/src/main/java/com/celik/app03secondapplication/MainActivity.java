package com.celik.app03secondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View view){

        Intent intent = null;

        switch (view.getId()) {

            case R.id.button_calculator:
                intent = new Intent(MainActivity.this,CalculatorActivity.class);
                break;

            case R.id.button_mass_index:
                intent = new Intent(MainActivity.this,MassActivity.class);
                break;

            case R.id.button_age_calculation:
                intent = new Intent(MainActivity.this,AgeActivity.class);
                break;
        }

        startActivity(intent);

    }
}