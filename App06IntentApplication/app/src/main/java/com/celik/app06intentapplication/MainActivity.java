package com.celik.app06intentapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonSms;
    Button buttonMail;
    Button buttonShare;
    Button buttonLink;
    Button buttonReturn;

    TextView textViewReturnedData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSms    = findViewById(R.id.button_sms);
        buttonMail   = findViewById(R.id.button_mail);
        buttonShare  = findViewById(R.id.button_share);
        buttonLink   = findViewById(R.id.button_link);
        buttonReturn = findViewById(R.id.button_return);


        buttonSms.setOnClickListener(this);
        buttonMail.setOnClickListener(this);
        buttonShare.setOnClickListener(this);
        buttonLink.setOnClickListener(this);
        buttonReturn.setOnClickListener(this);

        textViewReturnedData = findViewById(R.id.text_view_returned_data);



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK){

            String name = data.getStringExtra("name");
            textViewReturnedData.setText("Returned Data : " + name);
        }

    }

    @Override
    public void onClick(View view) {

        Intent intent;

        switch (view.getId()) {

            case R.id.button_sms:
                intent = new Intent(MainActivity.this,SmsActivity.class);
                startActivity(intent);
                break;

            case R.id.button_mail:
                intent = new Intent(MainActivity.this,MailActivity.class);
                startActivity(intent);
                break;

            case R.id.button_share:
                intent = new Intent(MainActivity.this,ShareActivity.class);
                startActivity(intent);
                break;

            case R.id.button_link:
                intent = new Intent(MainActivity.this,LinkActivity.class);
                startActivity(intent);
                break;

            case R.id.button_return:
                intent = new Intent(MainActivity.this,ReturnActivity.class);
                startActivityForResult(intent,1);
                break;

        }

    }
}