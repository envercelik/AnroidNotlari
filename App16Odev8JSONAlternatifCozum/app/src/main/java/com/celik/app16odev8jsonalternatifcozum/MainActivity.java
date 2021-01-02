package com.celik.app16odev8jsonalternatifcozum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {


    DataService dataService;
    Spinner spinner;
    ListView listViewLesson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataService = new DataService(this);
        spinner = findViewById(R.id.spinner_teacher_name);
        spinner.setOnItemSelectedListener(this);

        listViewLesson = findViewById(R.id.list_view_lessons);
        listViewLesson.setOnItemClickListener(this);


        setTeacherOnSpinner();

    }


    //data servis sınıfı ile çekilen öğretim görevlilerini spinner'a set eder.
    public void setTeacherOnSpinner() {
        dataService.getTeachers(new DataService.TeacherResponseListener() {

            @Override
            public void onResponse(List<Teacher> teachers) {

                spinner = findViewById(R.id.spinner_teacher_name);
                ArrayAdapter<Teacher> spinnerAdapter =
                        new ArrayAdapter<>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,teachers);
                spinner.setAdapter(spinnerAdapter);

            }

            @Override
            public void onError(String message) {

            }
        });
    }

    //Spinner'dan seçilen öğretim görevlisine göre listView'a dersleri set eder.
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        Teacher teacher = (Teacher) adapterView.getItemAtPosition(i);
        int registry = teacher.getRegistry();

        dataService.getLessonsByTeacherRegistry(registry,new DataService.LessonResponseListener() {

            @Override
            public void onResponse(List<Lesson> lessons) {

                ArrayAdapter<Lesson> lessonArrayAdapter =
                        new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,lessons);
                listViewLesson.setAdapter(lessonArrayAdapter);

            }

            @Override
            public void onError(String message) {

            }
        });
    }

    //Listview'da derse tıklandığında ders bilgilerini Toast mesaj olarak yayınlar
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Lesson lesson = (Lesson) adapterView.getItemAtPosition(i);
        String message = lesson.getCode() + " , " + lesson.getName() + " , " + lesson.getCredit();
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}