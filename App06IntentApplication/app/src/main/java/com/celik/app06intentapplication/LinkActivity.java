package com.celik.app06intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LinkActivity extends AppCompatActivity {

    EditText editTextLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);

        editTextLink = findViewById(R.id.edit_text_link);
    }

    public void openLink(View view) {

        String link = editTextLink.getText().toString();


        Intent intent = new Intent(Intent.ACTION_VIEW);

        intent.setData(Uri.parse(link));

        startActivity(intent);

    }
}