package com.celik.app02odev1calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewCalculatorScreen;
    double number1;
    String operator;
    boolean isResult = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCalculatorScreen = findViewById(R.id.text_view_calculator_screen);

    }


    //Nokta dahil tıklanan rakamı alır ve hesaplama ekranını günceller
    public void getNumber(View view){


        //ekranda error veya sonuç değeri var ise temizle (yeni bir hesaplama yapmak için gerekli)
        if (isResult || textViewCalculatorScreen.getText().toString().equals("error")) {
            textViewCalculatorScreen.setText("");
            isResult = false;
        }


        switch (view.getId()) {

            case R.id.button_number0:
                updateCalculatorScreen("0");
                break;

            case R.id.button_number1:
                updateCalculatorScreen("1");
                break;

            case R.id.button_number2:
                updateCalculatorScreen("2");
                break;

            case R.id.button_number3:
                updateCalculatorScreen("3");
                break;

            case R.id.button_number4:
                updateCalculatorScreen("4");
                break;

            case R.id.button_number5:
                updateCalculatorScreen("5");
                break;

            case R.id.button_number6:
                updateCalculatorScreen("6");
                break;

            case R.id.button_number7:
                updateCalculatorScreen("7");
                break;

            case R.id.button_number8:
                updateCalculatorScreen("8");
                break;

            case R.id.button_number9:
                updateCalculatorScreen("9");
                break;

            case R.id.button_dot:
                updateCalculatorScreen(".");
                break;
        }

    }


    //tıklanan operatörü alır.Ekrandan 1.sayıyı alır ve ekranı temizler
    public void getOperator(View view){

        switch (view.getId()) {
            case R.id.button_plus:
                getNumberAndCleanScreen();
                operator = "+";
                break;

            case R.id.button_minus:
                getNumberAndCleanScreen();
                operator = "-";
                break;


            case R.id.button_asterisk:
                getNumberAndCleanScreen();
                operator = "*";
                break;


            case R.id.button_division:
                getNumberAndCleanScreen();
                operator = "/";
                break;
        }
    }


    //ekrandaki sayıya yeni rakamı ekler
    public void updateCalculatorScreen(String current){
        String newCurrent = textViewCalculatorScreen.getText().toString() + current;
        textViewCalculatorScreen.setText(newCurrent);
    }


    //ekrandan 1.sayıyı alır ve ekranı temizler
    public void getNumberAndCleanScreen() {

        String number = textViewCalculatorScreen.getText().toString();

        if (isValidNumber(number)) {
            number1 = Double.parseDouble(number);
            textViewCalculatorScreen.setText("");

        } else {
            textViewCalculatorScreen.setText("error");
        }

    }


    //ekrandan 2. sayıyı alır  sonucu hesaplar ve ekranda gösterir.
    public void calculate(View view) {

        String number = textViewCalculatorScreen.getText().toString();
        double number2 = 0.0;


        if (isValidNumber(number)) {
            number2 = Double.parseDouble(number);

            double result = 0.0;

            switch (operator) {
                case "+":
                    result = number1+number2;
                    break;

                case "-":
                    result = number1-number2;
                    break;

                case "*":
                    result = number1*number2;
                    break;

                case "/":
                    result = number1/number2;
                    break;
            }

            textViewCalculatorScreen.setText(String.valueOf(result));
            isResult = true;

        }  else {
            textViewCalculatorScreen.setText("error");
        }

    }


    //sayının geçerli bir sayı olup olmadığını kontrol eder.
    public boolean isValidNumber(String number) {

        if (number.equals("")) {
            return false;
        }

        if (number.equals("error")) {
            return false;
        }

        if (number.charAt(0) == '.' || number.charAt(number.length()-1)== '.') {
            return false;
        }

        return  true;
    }


}