package com.celik.app05layouttypes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LinearActivity extends AppCompatActivity {

    String savedUserName = "yasin";
    String savedPassword = "123456";

    EditText editTextUserName;
    EditText editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        editTextUserName = findViewById(R.id.edit_text_user_name);
        editTextPassword = findViewById(R.id.edit_text_password);


    }

    public void login(View view) {

        String userName = editTextUserName.getText().toString();
        String password = editTextPassword.getText().toString();

        if (userName.equals(savedUserName) && password.equals(savedPassword)) {
            Toast.makeText(getApplicationContext(),"login successfully",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(),"login failed",Toast.LENGTH_LONG).show();
        }



    }

}