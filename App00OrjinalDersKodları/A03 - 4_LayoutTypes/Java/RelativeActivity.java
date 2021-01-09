package ders.yasin.layouttypes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class RelativeActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    ImageView ivImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
        relativeLayout=findViewById(R.id.relative);
        ivImage=findViewById(R.id.iv_Image);
    }
    public void ButtonClick(View v){
        int ID=v.getId();
        if(ID==R.id.btn_Color)
            relativeLayout.setBackgroundColor(Color.BLUE);
        else if(ID==R.id.btn_Image)
            ivImage.setImageDrawable(getResources().getDrawable(R.drawable.android));
    }
}
