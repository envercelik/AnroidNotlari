package com.celik.app15odev8json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String URL = "https://web.karabuk.edu.tr/yasinortakci/dokumanlar/web_dokumanlari/school.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RequestQueue queue = Volley.newRequestQueue(this);


        StringRequest request = new StringRequest(Request.Method.GET, URL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        ArrayList<Teacher> teachers = new ArrayList<>();
                        ArrayList<Lesson> lessons = new ArrayList<>();


                        try {

                            //Json Parse ile tüm ders ve öğretim elemanlarının arraylistlere alınması

                            JSONObject jsonData = new JSONObject(response);
                            JSONArray jsonArrayLesson = jsonData.getJSONArray("Dersler");
                            JSONArray jsonArrayTeacher = jsonData.getJSONArray("OgretimElemanlari");


                            for (int i=0; i<jsonArrayTeacher.length(); i++) {

                                JSONObject jsonObjectTeacher = jsonArrayTeacher.getJSONObject(i);

                                String name = jsonObjectTeacher.getString("adi");
                                int registry = jsonObjectTeacher.getInt("sicil");

                                teachers.add(new Teacher(name,registry));
                            }



                            for (int i=0; i<jsonArrayLesson.length(); i++) {

                                JSONObject jsonObjectLesson = jsonArrayLesson.getJSONObject(i);

                                String code = jsonObjectLesson.getString("Kodu");
                                String name = jsonObjectLesson.getString("Adi");
                                int teacherRegistry = jsonObjectLesson.getInt("OgretmenSicil");
                                int credit = jsonObjectLesson.getInt("Kredisi");

                                lessons.add(new Lesson(code,name,teacherRegistry,credit));

                            }



                            //Öğretim elemanın isimlerinin spinnera set edilmesi
                            Spinner spinner = findViewById(R.id.spinner_teacher_name);
                            ArrayAdapter<Teacher> spinnerAdapter =
                                    new ArrayAdapter<>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,teachers);
                            spinner.setAdapter(spinnerAdapter);

                            //Spinnerda bir öğretim görevlisi seçildiğinde bu öğretim görevlisine ait derslerin
                            //listview a set edilmesi
                            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                    //Öğretim görevlisine ait derlerin seçilip arraliste alınması
                                    Teacher teacher = (Teacher) adapterView.getItemAtPosition(i);
                                    ArrayList<Lesson> teacherLessons = new ArrayList<>();

                                    for (Lesson lesson : lessons) {

                                        if (teacher.getRegistry() == lesson.getTeacherRegistry()) {
                                            teacherLessons.add(lesson);
                                        }
                                    }



                                    //Öğretim görevlisine ait derslerin listview a set edilmesi
                                    ListView listViewLesson = findViewById(R.id.list_view_lessons);
                                    ArrayAdapter<Lesson> lessonArrayAdapter =
                                            new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,teacherLessons);
                                    listViewLesson.setAdapter(lessonArrayAdapter);
                                    listViewLesson.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                                        //listview da derslere tıklandığında ders ile ilgili toast mesaj yayınlanması
                                        @Override
                                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                            Lesson lesson = (Lesson) adapterView.getItemAtPosition(i);
                                            String message = lesson.getCode() + " , " + lesson.getName() + " , " + lesson.getCredit();
                                            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
                                        }


                                    });

                                }


                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {

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
                        Log.e("volleyError",error.getMessage());
                    }
                }


        );

        queue.add(request);




    }

}