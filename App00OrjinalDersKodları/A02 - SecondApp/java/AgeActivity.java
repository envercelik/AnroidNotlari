package ders.yasin.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AgeActivity extends AppCompatActivity {
    Button btnComputeAge;
    EditText etBirthYear;
    TextView tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        btnComputeAge=findViewById(R.id. btn_ComputeAge);
        etBirthYear=findViewById(R.id.et_BirthYear);
        tvAge=findViewById(R.id.tv_Age);

        btnComputeAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvAge.setText("");
                String birthYear=etBirthYear.getText().toString();
                if(!TextUtils.isEmpty(birthYear)){
                    int currentYear= Calendar.getInstance().get(Calendar.YEAR);
                    int year=Integer.parseInt(birthYear);
                    if(year<currentYear) {
                        int age = currentYear - year;
                        tvAge.setText("You are " + age + " years old.");
                    }else{
                        Toast.makeText(getApplicationContext(),"You should enter a previous date",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"You did not enter a birth year",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}