package ders.yasin.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvText;
    Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvText=findViewById(R.id.tv_Text);
        btnChange=findViewById(R.id.btn_Change);
    }


    public void ChangeText(View view){
        tvText.setText("Android'e hoşgeldiniz");
    }

    public void ChangeColor(View view){
        tvText.setTextColor(Color.BLUE);
    }

    public void StartSecondActivity(View v){
        Intent intent=new Intent (MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}