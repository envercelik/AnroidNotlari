package com.celik.app06intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MailActivity extends AppCompatActivity {

    EditText editTextMailAddress;
    EditText editTextMailSubject;
    EditText editTextMailBody;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);

        editTextMailAddress  = findViewById(R.id.edit_text_mail_address);
        editTextMailSubject  = findViewById(R.id.edit_text_mail_subject);
        editTextMailBody     = findViewById(R.id.edit_text_mail_body);

    }


    public void sendMail(View view) {

        String mailAddress = editTextMailAddress.getText().toString();
        String mailSubject = editTextMailSubject.getText().toString();
        String mailBody    = editTextMailBody.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");

        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{mailAddress});
        intent.putExtra(Intent.EXTRA_SUBJECT,mailSubject);
        intent.putExtra(Intent.EXTRA_TEXT,mailBody);

        startActivity(intent);


    }
}