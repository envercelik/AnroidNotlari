package ders.yasin.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvNewUser;
    EditText etLoginUN,etLoginPass;
    Button btnLogin,btn_AllUsers;
    SQLiteHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvNewUser=findViewById(R.id.tv_NewUSer);
        etLoginUN=findViewById(R.id.et_LoginUN);
        etLoginPass=findViewById(R.id.et_LoginPass);
        btnLogin=findViewById(R.id.btn_Login);
        btn_AllUsers=findViewById(R.id.btn_AllUsers);
        btn_AllUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,UserListActivity.class);
                startActivity(i);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=etLoginUN.getText().toString();
                String password=etLoginPass.getText().toString();
                database=new SQLiteHelper(MainActivity.this);
                String realPassword=database.findUser(userName);
                if(realPassword.equals(password)){
                    Intent i=new Intent(MainActivity.this,WelcomeActivity.class);
                    i.putExtra("USERNAME",userName);
                    startActivity(i);
                }
            }
        });

        tvNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}