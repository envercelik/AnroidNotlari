package com.celik.app03secondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MassActivity extends AppCompatActivity {

    Button buttonComputeMass;
    EditText editTextHeight;
    EditText editTextWeight;
    TextView textViewMassResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);

        buttonComputeMass = findViewById(R.id.button_compute_mass);
        editTextHeight = findViewById(R.id.edit_text_height);
        editTextWeight = findViewById(R.id.edit_text_weight);
        textViewMassResult = findViewById(R.id.text_view_mass_result);


        buttonComputeMass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double height = Double.parseDouble(editTextHeight.getText().toString());
                double weight = Double.parseDouble(editTextWeight.getText().toString());
                double massIndex = weight/(height*height);
                textViewMassResult.setText("Result : " + massIndex);
            }
        });

    }
}