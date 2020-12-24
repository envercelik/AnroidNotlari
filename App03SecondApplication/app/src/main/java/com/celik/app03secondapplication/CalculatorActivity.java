package com.celik.app03secondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAddition;
    Button buttonSubtraction;
    Button buttonMultiplication;
    Button buttonDivision;

    EditText editTextNumber1;
    EditText editTextNumber2;

    TextView textViewCalculatorResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        buttonAddition = findViewById(R.id.button_addition);
        buttonSubtraction = findViewById(R.id.button_subtraction);
        buttonMultiplication = findViewById(R.id.button_multiplication);
        buttonDivision = findViewById(R.id.button_division);

        buttonAddition.setOnClickListener(this);
        buttonSubtraction.setOnClickListener(this);
        buttonMultiplication.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);

        editTextNumber1 = findViewById(R.id.edit_text_number1);
        editTextNumber2 = findViewById(R.id.edit_text_number2);


        textViewCalculatorResult = findViewById(R.id.text_view_calculator_result);


    }

    @Override
    public void onClick(View view) {

        String firstNumber = editTextNumber1.getText().toString();
        String secondNumber = editTextNumber2.getText().toString();

        if (!TextUtils.isEmpty(firstNumber) && !TextUtils.isEmpty(secondNumber)) {

            double number1 = Double.parseDouble(firstNumber);
            double number2 = Double.parseDouble(secondNumber);
            double result = 0;

            switch (view.getId()) {
                case R.id.button_addition:
                    result = number1+number2;
                    break;

                case R.id.button_subtraction:
                    result = number1-number2;
                    break;

                case R.id.button_multiplication:
                    result = number1*number2;
                    break;

                case R.id.button_division:
                    if (number2 ==0) {
                        Toast.makeText(getApplicationContext(),"2.sayı sıfır olamaz",Toast.LENGTH_LONG).show();
                    } else {
                        result = number1/number2;
                    }
                    break;
            }

            textViewCalculatorResult.setText("Result : " + result);

        } else {
            Toast.makeText(getApplicationContext(),"sayı alanları boş bırakılamaz. ",Toast.LENGTH_LONG).show();
        }


    }
}