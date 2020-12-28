package com.celik.app10loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    ListView listViewUsers;
    SQLiteHelper sqLiteHelper;
    ArrayList<String> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        listViewUsers = findViewById(R.id.listview_users);
        sqLiteHelper = new SQLiteHelper(this);

        users = sqLiteHelper.listUsers();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,users);

        listViewUsers.setAdapter(adapter);


    }
}