package com.celik.app20odev10asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String path = "https://www.sci.utah.edu/~macleod/docs/txt2html/sample.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }


    public void downloadText(View view) {

        new DownloadTextInBackground().execute(path);
    }





    private class DownloadTextInBackground extends AsyncTask<String, Integer ,String> {


        ProgressDialog progressBar = new ProgressDialog(MainActivity.this);


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setProgress(0);
            progressBar.setMax(100);
            progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressBar.show();
        }


        @Override
        protected String doInBackground(String... strings) {

            String text = "";

            try {

                URL url = new URL(strings[0]);
                URLConnection connection = url.openConnection();
                connection.connect();

                int fileSize = connection.getContentLength();
                int downloadedSize=0;

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));


                String str;
                while ((str = reader.readLine()) != null) {

                    downloadedSize += str.length();
                    double rate=(double) downloadedSize/fileSize*100;
                    publishProgress((int)rate);
                    text = text + "\n" +str;
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
            return text;
        }




        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText(s);
            progressBar.dismiss();

        }


    }


}