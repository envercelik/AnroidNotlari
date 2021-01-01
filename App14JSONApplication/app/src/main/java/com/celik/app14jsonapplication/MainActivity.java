package com.celik.app14jsonapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    ListView listViewCompany;
    ImageView imageViewCompanyLogo;
    String URL="https://web.karabuk.edu.tr/yasinortakci/dokumanlar/web_dokumanlari/recyle.json";
    String [] logoURLs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewCompany = findViewById(R.id.list_view_company);
        imageViewCompanyLogo = findViewById(R.id.image_view_company_logo);

        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.GET, URL,
            new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("Companies");
                    String [] companyInfo=new String[jsonArray.length()];
                    logoURLs=new String[jsonArray.length()];
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject company=jsonArray.getJSONObject(i);
                        companyInfo[i]=company.getString("Heading")+ "-" +company.getString("Detail");
                        logoURLs[i]=company.getString("ImageURL");
                    }
                    ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,companyInfo);
                    listViewCompany.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VolleyError",error.getMessage());
            }
        });

        
        queue.add(request);

        listViewCompany.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int clickedItemIndex, long l) {
                Picasso.get().load(logoURLs[clickedItemIndex]).into(imageViewCompanyLogo);
            }
        });

    }
}