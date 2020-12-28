package com.celik.app10loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView textViewWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textViewWelcome = findViewById(R.id.text_view_welcome);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        textViewWelcome.setText("Welcome :" + userName);

    }


    public void goToUserListActivity(View view) {
        Intent intent = new Intent(this,UserListActivity.class);
        startActivity(intent);
    }


}