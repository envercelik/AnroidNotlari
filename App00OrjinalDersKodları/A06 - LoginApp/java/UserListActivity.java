package ders.yasin.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {
    ListView lvUsers;
    SQLiteHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        lvUsers=findViewById(R.id.lv_Users);
        database=new SQLiteHelper(UserListActivity.this);
        ArrayList<String> userList=database.getAllUsers();

        ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,userList);
        lvUsers.setAdapter(adapter);

    }
}