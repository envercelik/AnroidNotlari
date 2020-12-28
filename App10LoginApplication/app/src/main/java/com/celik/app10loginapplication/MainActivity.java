package com.celik.app10loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextUserName;
    EditText editTextPassword;

    SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUserName = findViewById(R.id.edit_text_username);
        editTextPassword = findViewById(R.id.edit_text_password);

        sqLiteHelper = new SQLiteHelper(this);

    }


    //Girilen kullanıcı adı ve şifre veritabanından çekilen ile eşleşirse WelcomeActivitye geçiş yapar.
    public void login(View view) {

        if (validateInput()) {

            String userName = editTextUserName.getText().toString();
            String password = editTextPassword.getText().toString();

            String userPassword = sqLiteHelper.findUser(userName);
            System.out.println(userPassword);

            if (!userPassword.equals("") && userPassword.equals(password)) {
                Intent intent = new Intent(MainActivity.this,WelcomeActivity.class);
                intent.putExtra("userName",userName);
                startActivity(intent);
            } else {
                Toast.makeText(this,"username or password is incorrect",Toast.LENGTH_LONG).show();
            }
        }

    }



    //kullanıcı adı veya şifre boş ise false döner
    public boolean validateInput() {

        if (TextUtils.isEmpty(editTextUserName.getText()) || TextUtils.isEmpty(editTextPassword.getText()) ) {
            Toast.makeText(this,"username or password cannot be empty",Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }



    //Kullanıcı kayıt ekranını açar.
    public void goToRegisterActivity(View view) {
        Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
    }


}