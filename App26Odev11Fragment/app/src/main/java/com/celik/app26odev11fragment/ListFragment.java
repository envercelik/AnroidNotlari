package com.celik.app26odev11fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    String url = "https://web.karabuk.edu.tr/yasinortakci/dokumanlar/web_dokumanlari/AndroidVersion.json";

    ListView listViewAndroidVersion;

    OnAndroidVersionListener versionListener;


    public ListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View viewFragmentList = inflater.inflate(R.layout.fragment_list, container, false);

        listViewAndroidVersion = viewFragmentList.findViewById(R.id.list_view_android_version);


        //get json data

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        ArrayList<String> androidVersionNames = new ArrayList();
                        ArrayList<String> androidVersionsNo = new ArrayList<>();
                        ArrayList<String> androidApisNo = new ArrayList<>();

                        ArrayAdapter arrayAdapter =
                                new ArrayAdapter(getActivity().getApplicationContext(),
                                        android.R.layout.simple_list_item_1,androidVersionNames);

                        try {

                            JSONArray jsonArray = new JSONArray(response);

                            for (int i=0; i<jsonArray.length(); i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String androidVersionName = jsonObject.getString("Name");
                                String androidVersionNo = jsonObject.getString("Version");
                                String androidApiNo = jsonObject.getString("APINo");

                                androidVersionNames.add(androidVersionName);
                                androidVersionsNo.add(androidVersionNo);
                                androidApisNo.add(androidApiNo);

                            }

                            listViewAndroidVersion.setAdapter(arrayAdapter);

                            listViewAndroidVersion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                    String name = androidVersionNames.get(i);
                                    String versionNo = androidVersionsNo.get(i);
                                    String apiNo = androidApisNo.get(i);

                                    versionListener.onSetAndroidVersionData(name,versionNo,apiNo);
                                }
                            });


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue.add(request);


        return  viewFragmentList;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            versionListener = (OnAndroidVersionListener) context;
        }
    }
}