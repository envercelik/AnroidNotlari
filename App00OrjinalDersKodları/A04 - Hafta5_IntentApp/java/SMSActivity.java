package ders.yasin.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SMSActivity extends AppCompatActivity {
    Button btnSendSMS;
    EditText etSMSText, etPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        btnSendSMS=findViewById(R.id.btn_SendSMS);
        etSMSText=findViewById(R.id.et_SMSText);
        etPhoneNumber=findViewById(R.id.et_PhoneNumber);
        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber=etPhoneNumber.getText().toString();
                String text=etSMSText.getText().toString();
                if(!TextUtils.isEmpty(phoneNumber)){
                    Intent sms=new Intent(Intent.ACTION_SENDTO);
                    sms.setData(Uri.parse("smsto:"+phoneNumber));
                    sms.putExtra("sms_body",text);
                    startActivity(sms);
                }
            }
        });
    }
}