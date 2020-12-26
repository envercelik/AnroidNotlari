package com.celik.app06intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ReturnActivity extends AppCompatActivity {

    EditText editTextName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return);

        editTextName = findViewById(R.id.edit_text_name);

    }

    public void returnData(View view) {

        String name = editTextName.getText().toString();

        Intent intent = new Intent();

        intent.putExtra("name",name);

        setResult(Activity.RESULT_OK ,intent);

        finish();


    }
}