package ders.yasin.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {
    Button btnRegister;
    EditText etRegisterUN,etName,etRegisterPass,etConfirm;
    SQLiteHelper sqlDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnRegister=findViewById(R.id.btn_Register);
        etRegisterUN=findViewById(R.id.et_Register_UN);
        etRegisterPass=findViewById(R.id.et_RegisterPass);
        etConfirm=findViewById(R.id.et_Confirm);
        etName=findViewById(R.id.et_Confirm);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=etRegisterUN.getText().toString();
                String name=etName.getText().toString();
                String password=etRegisterPass.getText().toString();
                String confirm=etConfirm.getText().toString();
                if((!TextUtils.isEmpty(userName))&&(!TextUtils.isEmpty(password))&& (!TextUtils.isEmpty(confirm))){
                    if(!password.equals(confirm)){
                        Toast.makeText(getApplicationContext(),"Passwords do not match",Toast.LENGTH_SHORT).show();
                    }else{
                        sqlDatabase=new SQLiteHelper(RegisterActivity.this) ;
                        if(sqlDatabase.insertUser(userName,name,password))
                            Toast.makeText(getApplicationContext(),"User is created succesfully",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getApplicationContext(),"User could not created",Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
}