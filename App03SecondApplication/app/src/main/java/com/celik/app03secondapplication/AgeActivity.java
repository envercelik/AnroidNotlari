package com.celik.app03secondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AgeActivity extends AppCompatActivity {

    Button buttonComputeAge;
    EditText editTextBirthYear;
    TextView textViewAgeResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        buttonComputeAge = findViewById(R.id.button_compute_age);
        editTextBirthYear = findViewById(R.id.edit_text_birth_year);
        textViewAgeResult = findViewById(R.id.text_view_age_result);


        buttonComputeAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                int birthYear = Integer.parseInt(editTextBirthYear.getText().toString());
                int age = currentYear-birthYear;

                if (age<0) {
                    Toast.makeText(getApplicationContext(),"Yanlış tarih girdiniz",Toast.LENGTH_LONG).show();
                } else {
                    textViewAgeResult.setText("Your Age : " + age);
                }


            }
        });
    }
}