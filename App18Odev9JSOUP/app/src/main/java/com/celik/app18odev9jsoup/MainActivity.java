package com.celik.app18odev9jsoup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String url = "https://www.karabuk.edu.tr";
    ListView listViewDuyurular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewDuyurular = findViewById(R.id.list_view_duyurular);



        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.GET, url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Document document = Jsoup.parse(response);
                        Elements elements = document.select("div#owl_duyurular a");

                        ArrayList<String> texts = new ArrayList<>();
                        ArrayList<String> href = new ArrayList<>();

                        for (Element element:elements) {
                            href.add(element.attr("href"));
                            texts.add(element.select("span.containerDuyuruBaslikLabel").text());
                        }


                        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                                getApplicationContext(), android.R.layout.simple_list_item_1,texts
                        );
                        listViewDuyurular.setAdapter(adapter);



                        listViewDuyurular.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                String link = href.get(i);
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse(link));
                                startActivity(intent);
                            }
                        });



                    }
                }
                ,

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                requestQueue.add(request);
    }
}