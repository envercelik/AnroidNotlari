package com.celik.app10loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextRegisterUserName;
    EditText editTextRegisterPassword;
    EditText editTextRegisterConfirmPassword;

    SQLiteHelper sqLiteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextRegisterUserName = findViewById(R.id.edit_text_register_username);
        editTextRegisterPassword = findViewById(R.id.edit_text_register_password);
        editTextRegisterConfirmPassword = findViewById(R.id.edit_text_register_confirm_password);

    }


    //Users tablosuna yeni kayıt ekler.
    public void register(View view) {

        if (validateInput()) {

            String userName = editTextRegisterUserName.getText().toString();
            String password = editTextRegisterPassword.getText().toString();


            sqLiteHelper = new SQLiteHelper(this);

            if (sqLiteHelper.addUser(userName,password)) {
                Toast.makeText(this,"your account is created successfully",Toast.LENGTH_LONG).show();
            }
        }



    }


    //tüm alanlar dolu değilse veya şifreler eşleşmiyorsa false döner
    public boolean validateInput() {

        if (TextUtils.isEmpty(editTextRegisterUserName.getText())) {
            Toast.makeText(this,"username cannot be empty",Toast.LENGTH_LONG).show();
            return false;
        }

        if (TextUtils.isEmpty(editTextRegisterPassword.getText())) {
            Toast.makeText(this,"password cannot be empty",Toast.LENGTH_LONG).show();
            return false;
        }

        if (TextUtils.isEmpty(editTextRegisterConfirmPassword.getText())) {
            Toast.makeText(this,"confirm password cannot be empty",Toast.LENGTH_LONG).show();
            return false;
        }


        if (!editTextRegisterPassword.getText().toString().equals(editTextRegisterConfirmPassword.getText().toString())) {
            Toast.makeText(this,"password do not match",Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }


}