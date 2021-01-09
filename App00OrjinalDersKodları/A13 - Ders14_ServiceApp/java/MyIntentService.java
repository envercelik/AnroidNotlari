package ders.yasin.serviceapp;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class MyIntentService extends IntentService {
    MediaPlayer mp;
    Vibrator vibrator;
    Boolean serviceFlag;

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        mp=MediaPlayer.create(this, R.raw.short_sound);
        vibrator=(Vibrator)getSystemService((Context.VIBRATOR_SERVICE));
        serviceFlag=true;
        Toast.makeText(getApplicationContext(),"Service thread id:"+Thread.currentThread().getId(),Toast.LENGTH_SHORT).show();
        Log.i("OnHandleService","Service thread id:"+Thread.currentThread().getId());
        run();
    }

    private void run() {
        while(serviceFlag){
            vibrator.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE));
            Log.i("Vibration","Vibration!!!!");
            mp.start();;
            Log.i("Sound","Playing!!!!");
            Log.i("Timer", "Thread number:" + Thread.currentThread().getId());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        serviceFlag=false;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }


}
