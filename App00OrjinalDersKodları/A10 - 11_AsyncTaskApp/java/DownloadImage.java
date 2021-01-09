package ders.yasin.asynctaskapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class DownloadImage extends AsyncTask<String,Integer,Bitmap> {
    Context context;
    Bitmap bmp;
    ProgressDialog progressDialog=new ProgressDialog(this.context);

    public DownloadImage(Context c) {
        super();
        this.context=c;

    }
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

    }


}
