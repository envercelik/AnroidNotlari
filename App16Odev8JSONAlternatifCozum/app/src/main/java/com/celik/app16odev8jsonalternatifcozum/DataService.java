package com.celik.app16odev8jsonalternatifcozum;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataService {

    Context context;
    String URL = "https://web.karabuk.edu.tr/yasinortakci/dokumanlar/web_dokumanlari/school.json";
    String data = "";

    public DataService(Context context) {
        this.context = context;
    }



    public interface TeacherResponseListener {

        void onError(String message);

        void onResponse(List<Teacher> teachers);

    }

    public void getTeachers(TeacherResponseListener teacherResponseListener) {

        List<Teacher>  teachers = new ArrayList<>();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArrayTeachers = response.getJSONArray("OgretimElemanlari");

                            for (int i=0; i<jsonArrayTeachers.length(); i++) {
                                JSONObject jsonObjectLesson = jsonArrayTeachers.getJSONObject(i);


                                String name = jsonObjectLesson.getString("adi");
                                int registry = jsonObjectLesson.getInt("sicil");


                                teachers.add(new Teacher(name,registry));
                            }

                            teacherResponseListener.onResponse(teachers);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }

        );


        RequestQueueSingleton.getInstance(context).addToRequestQueue(request);



    }


    

    public interface LessonResponseListener {

        void onError(String message);

        void onResponse(List<Lesson> lessons);

    }

    public void getLessonsByTeacherRegistry(int registry , LessonResponseListener lessonResponseListener) {

        List<Lesson>  lessons = new ArrayList<>();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null,

           new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArrayLessons = response.getJSONArray("Dersler");

                    for (int i=0; i<jsonArrayLessons.length(); i++) {
                        JSONObject jsonObjectLesson = jsonArrayLessons.getJSONObject(i);

                        String code = jsonObjectLesson.getString("Kodu");
                        String name = jsonObjectLesson.getString("Adi");
                        int teacherRegistry = jsonObjectLesson.getInt("OgretmenSicil");
                        int credit = jsonObjectLesson.getInt("Kredisi");

                        if (teacherRegistry == registry) {
                            lessons.add(new Lesson(code,name,teacherRegistry,credit));
                        }

                    }

                    lessonResponseListener.onResponse(lessons);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },

        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }

        );


        RequestQueueSingleton.getInstance(context).addToRequestQueue(request);



    }

}
