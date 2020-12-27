package com.celik.app09odev5permission;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    EditText editTextPhoneNumber;
    ImageView imageViewCaptureImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPhoneNumber = findViewById(R.id.edit_text_phone_number);
        imageViewCaptureImage = findViewById(R.id.image_view_capture_image);

    }



    public void takePhotoAndSendSms(View view) {

        int permissionOfCamera = ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA);
        int permissionOfSms = ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS);

        if (permissionOfCamera == PackageManager.PERMISSION_GRANTED && permissionOfSms == PackageManager.PERMISSION_GRANTED){
            takePhoto();
        } else {

            String[] permissions = {Manifest.permission.CAMERA,Manifest.permission.SEND_SMS};
            ActivityCompat.requestPermissions(this,permissions,2);
        }

    }



    public void takePhoto(){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {

            //get image capture and set on imageView
            Bitmap captureImage = (Bitmap) data.getExtras().get("data");
            imageViewCaptureImage.setImageBitmap(captureImage);

            sendSms();
        }
    }



    public void sendSms() {

        String phoneNumber = editTextPhoneNumber.getText().toString();

        if (phoneNumber.equals("")) {
            Toast.makeText(this,"invalid phone number - could not send sms ",Toast.LENGTH_LONG).show();

        } else {

            String smsBody = "photo was taken";

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber,null,smsBody,null,null);

            Toast.makeText(this,"sending sms",Toast.LENGTH_LONG).show();
        }




    }



}