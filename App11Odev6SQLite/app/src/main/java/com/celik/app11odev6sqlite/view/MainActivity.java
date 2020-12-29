package com.celik.app11odev6sqlite.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.celik.app11odev6sqlite.R;
import com.celik.app11odev6sqlite.data.DatabaseHelper;
import com.celik.app11odev6sqlite.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    DatabaseHelper databaseHelper;
    ArrayList<Contact> contacts;
    ArrayAdapter<Contact> arrayAdapter;
    ListView listViewContact;
    Contact selectedContact = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializes();

    }

    //Menuden seçilen iteme göre işlemler yapar.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() ==R.id.new_contact) {
            Intent intent = new Intent(this,NewContactActivity.class);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.update_contact) {

            if (selectedContact != null) {

                Intent intent = new Intent(this,UpdateContactActivity.class);
                intent.putExtra("contact",selectedContact);
                startActivity(intent);
            } else {
                Toast.makeText(this,"you should select a contact",Toast.LENGTH_LONG).show();
            }


        }

        if (item.getItemId() == R.id.delete_contact) {
            deleteContact();
        }

        if (item.getItemId() == R.id.call_contact) {
            callContact();
        }

        if (item.getItemId() == R.id.exit) {
            exit();
        }

        return super.onOptionsItemSelected(item);
    }

    //uygulamayı kapatır.(tamamen)
    public void exit() {

        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    //seçilen contact ı siler.
    public void deleteContact() {

        if (selectedContact != null) {

            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Delete Contact");
            alert.setMessage("Are you sure you want to delete contact : " + selectedContact.getNameSurname());

            alert.setNegativeButton("Cancel", null);

            alert.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                    databaseHelper.deleteContact(selectedContact.getId());

                    contacts.remove(selectedContact);
                    arrayAdapter.notifyDataSetChanged();
                    listViewContact.setAdapter(arrayAdapter);
                    selectedContact = null;

                }});

            alert.show();

        } else {
            Toast.makeText(this,"you should select a contact",Toast.LENGTH_LONG).show();
        }

    }

    //izin varsa arama yapar . yoksa izin ister
    public void callContact(){

        if (selectedContact != null) {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                makeCall();
            } else {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
            }

        } else {
            Toast.makeText(this,"you should select a contact",Toast.LENGTH_LONG).show();
        }

    }

    //seçilen contact ı arar(call).
    public void makeCall() {

        if (selectedContact != null) {

            String phoneNumber = selectedContact.getPhoneNumber();

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+phoneNumber));
            startActivity(intent);

        } else {
            Toast.makeText(this,"you should select a contact",Toast.LENGTH_LONG).show();
        }

    }

    //arama için izin verildiğinde çalışır
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (selectedContact != null) {
            if (requestCode==1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makeCall();
            }
        } else {
            Toast.makeText(this,"you should select a contact",Toast.LENGTH_LONG).show();
        }


    }


    //listeden seçilen contact ı alır.
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        selectedContact = (Contact) adapterView.getItemAtPosition(i);
    }


    //contact option menuyu main activity e bağlar.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = this.getMenuInflater();
        menuInflater.inflate(R.menu.contacts_option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void initializes(){

        databaseHelper = new DatabaseHelper(this);
        contacts = new ArrayList<>(databaseHelper.getAllContact());
        arrayAdapter = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1,contacts);
        listViewContact = findViewById(R.id.list_view_contact);
        listViewContact.setAdapter(arrayAdapter);
        listViewContact.setOnItemClickListener(this);
    }

}