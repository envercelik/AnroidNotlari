package com.celik.app07odev4intend;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goToInputActivity(View view) {

        Intent intent = new Intent(MainActivity.this ,InputActivity.class);
        startActivityForResult(intent,1);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {

            String cleanText = data.getStringExtra("cleanText");
            Toast.makeText(MainActivity.this,cleanText,Toast.LENGTH_LONG).show();


            int removedCharacterCount = data.getIntExtra("removedCharacterCount",0);
            String removedCharacterCountMessage= "Removed Character Count : " + removedCharacterCount;




            Toast.makeText(MainActivity.this,removedCharacterCountMessage,Toast.LENGTH_LONG).show();

        }

    }
}