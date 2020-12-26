package com.celik.app06intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ShareActivity extends AppCompatActivity {

    EditText editTextShareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        editTextShareText = findViewById(R.id.edit_text_share_text);
    }


    public void share(View view) {

        String shareText = editTextShareText.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");

        intent.putExtra(Intent.EXTRA_TEXT,shareText);

        Intent chooser = Intent.createChooser(intent,"Select Platform");
        startActivity(chooser);

    }
}