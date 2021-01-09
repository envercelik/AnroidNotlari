package ders.yasin.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BodyMass extends AppCompatActivity {
    Button btnComputeMass;
    EditText etWeight,etHeight;
    TextView tvMassResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodymass);
        btnComputeMass=findViewById(R.id.btn_ComputeMass);
        etHeight=findViewById(R.id.et_Height);
        etWeight=findViewById(R.id.et_Weight);
        tvMassResult=findViewById(R.id.tv_MassResult);

        btnComputeMass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double height=Double.parseDouble(etHeight.getText().toString());
                double weight=Double.parseDouble(etWeight.getText().toString());
                double massIndex=weight/Math.pow(height,2);
                if (massIndex>25)
                    tvMassResult.setText("Obez");
                else
                    tvMassResult.setText(String.valueOf(massIndex));
            }
        });
    }
}