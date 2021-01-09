package ders.yasin.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void ButtonClick(View v){
        int id=v.getId();
        Intent intent;
        switch (id){
            case R.id.btn_Calc:
                intent=new Intent(MainActivity.this,Calculator.class);
                startActivity(intent);
                break;
            case R.id.btn_Mass:
                intent=new Intent(MainActivity.this,BodyMass.class);
                startActivity(intent);
                break;
            case R.id.btn_Age:
                intent=new Intent(MainActivity.this,AgeActivity.class);
                startActivity(intent);
                break;
        }


    }
}