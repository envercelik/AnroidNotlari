package ders.yasin.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ShareActivity extends AppCompatActivity {
    EditText etShare;
    Button btnShareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        etShare=findViewById(R.id.et_Share);
        btnShareText=findViewById(R.id.btn_ShareText);
        btnShareText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=etShare.getText().toString();
                Intent share=new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT,text);
                startActivity(Intent.createChooser(share,"Select platform"));
            }
        });
    }
}