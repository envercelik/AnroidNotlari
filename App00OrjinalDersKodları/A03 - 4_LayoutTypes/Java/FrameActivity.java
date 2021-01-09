package ders.yasin.layouttypes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameActivity extends AppCompatActivity {
    Button btnVisible;
    ImageView iv1,iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        btnVisible=findViewById(R.id.btn_Visible);
        iv1=findViewById(R.id.iv_1);
        iv2=findViewById(R.id.iv_2);
        btnVisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv1.setVisibility(View.VISIBLE);
                iv2.setVisibility(View.INVISIBLE);
            }
        });
    }
}
