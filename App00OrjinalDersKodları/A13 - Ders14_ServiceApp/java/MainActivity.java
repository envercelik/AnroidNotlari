package ders.yasin.serviceapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnStartService,btnStopService;
    Intent intentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStartService=findViewById(R.id.btn_StartService);
        btnStopService=findViewById(R.id.btn_StopService);
        btnStopService.setOnClickListener(this);
        btnStartService.setOnClickListener(this);
        intentService= new Intent(MainActivity.this, MyIntentService.class);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_StartService:
                Log.i("ButtonStart","MainActivity thread id:"+Thread.currentThread().getId());
                startService(intentService); break;
            case R.id.btn_StopService: stopService(intentService); break;
        }
    }
}