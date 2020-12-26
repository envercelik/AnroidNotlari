package com.celik.app06intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SmsActivity extends AppCompatActivity {

    EditText editTextPhoneNumber;
    EditText editTextSmsBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        editTextPhoneNumber = findViewById(R.id.edit_text_phone_number);
        editTextSmsBody = findViewById(R.id.edit_text_sms_body);

    }


    public void sendSms(View view){

        String phoneNumber = editTextPhoneNumber.getText().toString();
        String smsContent = editTextSmsBody.getText().toString();


        Intent intent = new Intent(Intent.ACTION_SENDTO);

        intent.setData(Uri.parse("smsto:"+phoneNumber));
        intent.putExtra("sms_body",smsContent);

        startActivity(intent);
        

    }
}