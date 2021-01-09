package ders.yasin.callpermission;

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
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etPhone;
    ImageButton ibCall;
    String phoneNumber;
    final static int CALL_REQUEST_CODE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPhone=findViewById(R.id.et_Phone);
        ibCall=findViewById(R.id.ib_Call);
        ibCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumber=etPhone.getText().toString();
                if(!TextUtils.isEmpty(phoneNumber)){
                    Call();
                }else{
                    Toast.makeText(getApplicationContext(),"Enter a phone number",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Call() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
            Intent call=new Intent(Intent.ACTION_CALL);
            call.setData(Uri.parse("tel:"+phoneNumber));
            startActivity(call);
        }else{
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Info");
                builder.setMessage("This application needs CALL permision to call someone");
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();                    }
                });
                builder.show();
            }
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},CALL_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==CALL_REQUEST_CODE){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Call();
            }else{
                Toast.makeText(getApplicationContext(),"You denied the call permission",Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_camera:
                Toast.makeText(getApplicationContext(),"Camera is selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_share:
                Toast.makeText(getApplicationContext(),"Share is selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_exit:
                System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }
}