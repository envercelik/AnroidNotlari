package com.celik.app01firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bir xml nesnesinin java nesnesi ile ilişkilendirilmesi
        textViewHello = findViewById(R.id.text_view_hello);

    }


    //Change Text butonuna tıklandığında çağrılır ve Hello World! yazısı Hello Android! ile değiştirir.
    public void changeText(View view) {
        textViewHello.setText("Hello Android!");
    }


    //Change Color butonuna tıklandığında çağrılır ve yazı rengini yeşil ile değiştirir.
    public void changeColor(View view) {
        textViewHello.setTextColor(Color.GREEN);
    }


    //Change Activity butonuna tıklandığında SecondActivity'e geçiş yapar.
    public void changeActivity(View view) {
        //MainActivity'den SecondActivity'e geçiş sağlar
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }
}