package ders.yasin.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity implements View.OnClickListener {
    EditText etNumber1,etNumber2;
    TextView tvResult;
    Button btnAdd,btnSubtract,btnMultiply,btnDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        etNumber1=findViewById(R.id.et_Number1);
        etNumber2=findViewById(R.id.et_Number2);
        tvResult=findViewById(R.id.tv_Result);
        btnDivision=findViewById(R.id.btn_Division);
        btnMultiply=findViewById(R.id.btn_Multiply);
        btnSubtract=findViewById(R.id.btn_Subtract);
        btnAdd=findViewById(R.id.btn_Add);

        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        double number1=Double.parseDouble(etNumber1.getText().toString());
        double number2=Double.parseDouble(etNumber2.getText().toString());
        double result=0.0;
        switch (id){
            case R.id.btn_Add:result=number1+number2; break;
            case R.id.btn_Subtract: result=number1-number2;break;
            case R.id.btn_Multiply: result=number1*number2;break;
            case R.id.btn_Division: result=number1/number2;
        }
        tvResult.setText("Sonuc="+result);
    }

}