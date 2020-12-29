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

public class UpdateContactActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    EditText editTextNameSurname;
    EditText editTextPhoneNumber;

    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);

        initializes();

        //listeden seçilen contact ın intend ile alınıp arayüze set edilmesi
        Intent intent = getIntent();
        contact = (Contact) intent.getSerializableExtra("contact");

        editTextNameSurname.setText(contact.getNameSurname());
        editTextPhoneNumber.setText(contact.getPhoneNumber());


    }


    //seçilen contact ı girilen yeni bilgilere göre günceller.
    public void updateContact(View view){

        String id = contact.getId();

        if (!TextUtils.isEmpty(editTextNameSurname.getText()) &&!TextUtils.isEmpty(editTextPhoneNumber.getText())) {

            String nameSurname = editTextNameSurname.getText().toString();
            String phoneNumber = editTextPhoneNumber.getText().toString();

            databaseHelper.updateContact(new Contact(id,nameSurname,phoneNumber));

            goToMainActivity();

        } else {

            Toast.makeText(this,"please check contact information",Toast.LENGTH_LONG).show();
        }


    }

    public void goToMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        finish();
        startActivity(intent);
    }


    public void initializes() {
        databaseHelper = new DatabaseHelper(this);
        editTextNameSurname = findViewById(R.id.edit_text_update_contact_activity_name_surname);
        editTextPhoneNumber = findViewById(R.id.edit_text_update_contact_activity_phone_number);
    }

}