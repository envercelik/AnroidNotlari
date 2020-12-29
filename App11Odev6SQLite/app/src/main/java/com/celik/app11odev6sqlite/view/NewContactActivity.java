package com.celik.app11odev6sqlite.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.celik.app11odev6sqlite.R;
import com.celik.app11odev6sqlite.data.DatabaseHelper;
import com.celik.app11odev6sqlite.model.Contact;

public class NewContactActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    EditText editTextNameSurname;
    EditText editTextPhoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        initializes();

    }

    //contact nesnesini veritabanına kayıt eder.
    public void saveNewContact(View view) {

        if (createContact() != null) {
            databaseHelper.newContact(createContact());
            goToMainActivity();
            finish();
        } else {
            Toast.makeText(this,"please check contact information",Toast.LENGTH_LONG).show();
        }
    }

    //Girilen contact verilerine göre bir contact nesnesi döndürür.
    public Contact createContact(){

        if (!TextUtils.isEmpty(editTextNameSurname.getText()) && !TextUtils.isEmpty(editTextPhoneNumber.getText())) {

            String nameSurname = editTextNameSurname.getText().toString();
            String phoneNumber = editTextPhoneNumber.getText().toString();

            return new Contact(nameSurname,phoneNumber);

        } else {
            return null;
        }



    }

    public void goToMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void initializes(){
        databaseHelper = new DatabaseHelper(this);
        editTextNameSurname = findViewById(R.id.edit_text_update_contact_activity_name_surname);
        editTextPhoneNumber = findViewById(R.id.edit_text_update_contact_activity_phone_number);
    }


}