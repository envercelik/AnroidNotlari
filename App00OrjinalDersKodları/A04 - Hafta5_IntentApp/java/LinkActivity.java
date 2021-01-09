package ders.yasin.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LinkActivity extends AppCompatActivity {
    TextView tvLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);
        tvLink=findViewById(R.id.tv_Link);
        tvLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent link=new Intent(Intent.ACTION_VIEW);
                link.setData(Uri.parse("https://www.karabuk.edu.tr"));
                startActivity(link);
            }
        });
    }
}