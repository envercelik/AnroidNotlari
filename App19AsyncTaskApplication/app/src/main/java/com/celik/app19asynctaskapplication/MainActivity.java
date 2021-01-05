package com.celik.app19asynctaskapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    Button btnDownload;
    ImageView ivDownload;
    String path1="https://i.stack.imgur.com/9gX57.jpg";
    String path = "https://4k-uhd.nl/wp-content/uploads/2018/08/4K-3840x2160-Wallpaper-Uitzicht-3.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDownload=findViewById(R.id.btn_Download);
        ivDownload=findViewById(R.id.iv_Download);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadImage downloadImage=new DownloadImage();
                downloadImage.execute(path1);
            }
        });
    }


    public class DownloadImage extends AsyncTask<String,Integer, Bitmap> {
        Context context;
        Bitmap bmp;
        ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setProgress(0);
            progressDialog.setMax(100);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.show();
        }
        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                URL url=new URL(params[0]);
                URLConnection connection=url.openConnection();
                connection.connect();

                int imageSize=connection.getContentLength();
                BufferedInputStream input=new BufferedInputStream(connection.getInputStream());
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                byte[] data=new byte[1024];
                int count=0;
                int totalCount=0;
                while((count=input.read(data))!=-1){
                    totalCount+=count;
                    output.write(data);
                    double rate=(double) totalCount/imageSize*100;
                    publishProgress((int)rate);
                }
                byte[] image=output.toByteArray();
                bmp = BitmapFactory.decodeByteArray(image, 0, image.length);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bmp;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressDialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            ivDownload.setImageBitmap(bitmap);
            progressDialog.dismiss();

        }


    }

}