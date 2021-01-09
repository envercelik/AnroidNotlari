package ders.yasin.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MailActivity extends AppCompatActivity {
    Button btnSendMail;
    EditText etMailAddress,etSubject,etMailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        btnSendMail=findViewById(R.id.btn_SendMail);
        etMailText=findViewById(R.id.et_MailText);
        etSubject=findViewById(R.id.et_Subject);
        etMailAddress=findViewById(R.id.et_Mail);
        btnSendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mailAddress=etMailAddress.getText().toString();
                String subject=etSubject.getText().toString();
                String mailText=etMailText.getText().toString();
                Intent mail=new Intent(Intent.ACTION_SEND);
                mail.setType("message/rfc822");
                mail.putExtra(Intent.EXTRA_TEXT,mailText);
                mail.putExtra(Intent.EXTRA_EMAIL,new String[]{mailAddress});
                mail.putExtra(Intent.EXTRA_SUBJECT,subject);
                startActivity(mail);

            }
        });
    }
}