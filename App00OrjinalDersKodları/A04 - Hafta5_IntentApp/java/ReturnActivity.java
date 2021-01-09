package ders.yasin.intentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReturnActivity extends AppCompatActivity {
    EditText etReturn;
    Button btnReturnText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return);
        etReturn=findViewById(R.id.et_Return);
        btnReturnText=findViewById(R.id.btn_ReturnText);
        btnReturnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=etReturn.getText().toString();
                Intent returnIntent=new Intent();
                returnIntent.putExtra("NAME",name);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }
}