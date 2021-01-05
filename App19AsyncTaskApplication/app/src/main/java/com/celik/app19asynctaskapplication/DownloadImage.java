package com.celik.app19asynctaskapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadImage extends AsyncTask<String,Integer ,Bitmap> {

    Context context;
    ImageView imageView;
    ProgressDialog progressDialog;


    public DownloadImage(Context context, ImageView imageView) {
        super();
        this.context = context;
        this.imageView = imageView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = new ProgressDialog(context);
        progressDialog.setProgress(0);
        progressDialog.setMax(100);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
    }

    @Override
    protected Bitmap doInBackground(String... params) {

        Bitmap bitmap = null;

        try {
            URL url = new URL(params[0]);
            URLConnection connection = url.openConnection();
            connection.connect();
            int imageSize = connection.getContentLength();

            BufferedInputStream input = new BufferedInputStream(connection.getInputStream());
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] data = new byte[1024];
            int count = 0;
            int totalSize = 0;

            while ((count = input.read(data)) !=-1) {
                output.write(data);
                totalSize+=count;
                double progress = (double) totalSize/imageSize*100;
                onProgressUpdate((int)progress);
            }
            byte[] imageArray = output.toByteArray();
            bitmap = BitmapFactory.decodeByteArray(imageArray,0,imageArray.length);





        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }


    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        imageView.setImageBitmap(bitmap);
        progressDialog.dismiss();

    }




}
