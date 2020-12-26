package com.celik.app07odev4intend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class InputActivity extends AppCompatActivity {

    EditText editTextUnclearedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        editTextUnclearedText = findViewById(R.id.edit_text_uncleared_text);

    }

    //^a-zA-ZİıÜüÇçŞşÖöĞğ ler dışında kalanlar "" ile değiştirilir.  a-z  aralık belirtir.
    //Not regex deseninin sonunda bırakılan bir boşluk nedeniyle metindeki boşluklar silinmez.
    public void clearText(View view) {

        String unclearedText = editTextUnclearedText.getText().toString();
        String cleanText = unclearedText.replaceAll("[^a-zA-ZİıÜüÇçŞşÖöĞğ ]","");
        int removedCharacterCount = unclearedText.length()-cleanText.length();


        Intent intent = new Intent();
        intent.putExtra("cleanText",cleanText);
        intent.putExtra("removedCharacterCount",removedCharacterCount);


        setResult(RESULT_OK,intent);
        finish();

    }
}