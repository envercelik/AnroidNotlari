package com.celik.app17jsoupapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String url = "https://karabuk.edu.tr";

    TextView textViewTitle;
    ListView listView;
    Button buttonDuyuru;
    Button buttonHaber;
    Button buttonLink;
    Button buttonDaire;
    ArrayList<String> veriler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        buttonDuyuru = findViewById(R.id.button_duyuru);
        buttonHaber = findViewById(R.id.button_haber);
        buttonLink = findViewById(R.id.button_link);
        buttonDaire = findViewById(R.id.button_daire);

        textViewTitle = findViewById(R.id.text_view_title);

        buttonDuyuru.setOnClickListener(this);
        buttonHaber.setOnClickListener(this);
        buttonLink.setOnClickListener(this);
        buttonDaire.setOnClickListener(this);
        veriler = new ArrayList<>();


    }

    @Override
    public void onClick(View view) {

        veriler.clear();

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Document document = Jsoup.parse(response);


                        if (view.getId() == R.id.button_duyuru) {

                            textViewTitle.setText("Duyurular");
                            Elements duyurular = document.select("span.containerDuyuruBaslikLabel");

                            for (Element duyuru : duyurular) {
                                veriler.add(duyuru.text());
                            }
                        } else if (view.getId() == R.id.button_haber) {
                            textViewTitle.setText("Haberler");
                            Elements haberler = document.select("div.haberBoxHeader");

                            for (Element haber : haberler) {
                                veriler.add(haber.text());
                            }

                        } else if (view.getId() == R.id.button_link) {
                            textViewTitle.setText("Linkler");
                            Elements linkler = document.select("div.haberBoxHeader a");

                            for (Element link : linkler) {
                                veriler.add(link.attr("href"));
                            }
                        } else if (view.getId() == R.id.button_daire) {

                            textViewTitle.setText("Daire Başkanlıkları");
                            Elements daireler = document.select("div.col-md-4 span");
                            for (Element daire : daireler) {
                                if (daire.text().equals("Daire Başkanlıkları")) {
                                    Element nextSibling = daire.nextElementSibling();
                                    Elements children = nextSibling.children();
                                    for (Element child : children) {
                                        veriler.add(child.text());
                                    }
                                }
                            }


                        }


                        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                                getApplicationContext(), android.R.layout.simple_list_item_1, veriler);

                        listView.setAdapter(adapter);


                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        queue.add(request);


    }
}