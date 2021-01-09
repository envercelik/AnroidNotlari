package ders.yasin.intentapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnMail,btnSMS,btnShare,btnLink,btnReturn;
    TextView tvName;
    final static int REQUEST_CODE=100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSMS=findViewById(R.id.btn_SMS);
        btnMail=findViewById(R.id.btn_Mail);
        btnShare=findViewById(R.id.btn_Share);
        btnLink=findViewById(R.id.btn_Link);
        btnReturn=findViewById(R.id.btn_Return);
        tvName=findViewById(R.id.tv_Name);
        btnSMS.setOnClickListener(this);
        btnMail.setOnClickListener(this);
        btnLink.setOnClickListener(this);
        btnShare.setOnClickListener(this);
        btnReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int ID=view.getId();
        Intent i;
        switch (ID){
            case R.id.btn_SMS:
                i=new Intent(MainActivity.this,SMSActivity.class);
                startActivity(i);
                break;
            case R.id.btn_Mail:
                i=new Intent(MainActivity.this,MailActivity.class);
                startActivity(i);
                break;
            case R.id.btn_Link:
                i=new Intent(MainActivity.this,LinkActivity.class);
                startActivity(i);
                break;
            case R.id.btn_Share:
                i=new Intent(MainActivity.this,ShareActivity.class);
                startActivity(i);
                break;
            case R.id.btn_Return:
                i=new Intent(MainActivity.this,ReturnActivity.class);
                startActivityForResult(i,REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE){
            if(resultCode==RESULT_OK){
                String name=data.getStringExtra("NAME");
                tvName.setText(name);
            }
        }
    }
}