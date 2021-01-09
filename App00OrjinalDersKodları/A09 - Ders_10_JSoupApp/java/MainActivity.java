package ders.yasin.jsoupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnDuyuru,btnHaber,btnLink,btnDaire;
    TextView tvTitle;
    ListView lvList;
    String URL="https://www.karabuk.edu.tr";
    ArrayList<String> dizi=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDuyuru=findViewById(R.id.btn_Duyuru);
        btnHaber=findViewById(R.id.btn_Haber);
        btnLink=findViewById(R.id.btn_Link);
        btnDaire=findViewById(R.id.btn_Daire);
        tvTitle=findViewById(R.id.tv_Title);

        lvList=findViewById(R.id.lv_List);
        btnDuyuru.setOnClickListener(this);
        btnHaber.setOnClickListener(this);
        btnLink.setOnClickListener(this);
        btnDaire.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        final int buttonID=view.getId();

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request=new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Document doc=Jsoup.parse(response);
                        switch (buttonID){
                            case R.id.btn_Duyuru:{
                                dizi.clear();
                                tvTitle.setText("Duyurular");
                                Elements duyurular=doc.select("span.containerDuyuruBaslikLabel");
                                for(Element duyuru:duyurular)
                                    dizi.add(duyuru.text());
                                break;
                            }
                            case R.id.btn_Haber:{
                                dizi.clear();
                                tvTitle.setText("Haberler");
                                Elements haberler = doc.select("div.haberBoxHeader");
                                for (Element haber : haberler) {
                                    dizi.add(haber.text());
                                }
                                break;
                            }
                            case R.id.btn_Link:{
                                dizi.clear();
                                tvTitle.setText("Linkler");
                                Elements linkler=doc.select("div.HaberBoxHeader a");
                                for(Element link:linkler) {
                                    dizi.add(link.attr("href"));
                                }
                                break;
                            }
                            case R.id.btn_Daire:{
                                dizi.clear();
                                tvTitle.setText("Daire Başkanlıkları");
                                Elements daireler= doc.select("div.col-md-4 span");
                                for (Element daire : daireler) {
                                    if(daire.text().equals("Daire Başkanlıkları")){
                                        Element nextSibling=daire.nextElementSibling();
                                        Elements children=nextSibling.children();
                                        for(Element child:children){
                                            dizi.add(child.text());
                                        }
                                    }
                                }
                                break;
                            }
                        }

                        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,dizi);
                        lvList.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
                 @Override
                public void onErrorResponse(VolleyError error) {
                     Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
                     Log.e("Error",error.getMessage());

                }
        });
        queue.add(request);




    }
}