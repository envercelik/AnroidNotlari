package com.celik.app08callapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextPhoneNumber;
    String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPhoneNumber = findViewById(R.id.edit_text_phone_number);

    }


    public void call(View view) {

        phoneNumber = editTextPhoneNumber.getText().toString();

        //daha önceden izin verilmiş mi ?  Not :ActivityCompat platform kontrolü gerekliliğini ortadan kaldırır
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {

            makeCall();

        } else {

            //Kullanıcının kafası karışık mı ?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)) {
                //izin ile ilgili açıklama yap
                showPermissionInfo();
            }

            //izin isteğinde bulun . İzin isteği için bir pop-up açılır.
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);

        }
    }


    //Verilen izinleri karşılar.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1){

            //izin olumlu mu ?
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                makeCall();
            } else {
                Toast.makeText(this,"User Denied call permission",Toast.LENGTH_LONG).show();
            }

        }

    }

    public void makeCall() {



        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+phoneNumber));
        startActivity(intent);
    }

    public void showPermissionInfo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Information");
        builder.setMessage("This application needs Call permission to call someone");

        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.show();
    }
}