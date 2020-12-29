package com.celik.app11odev6sqlite.data;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;

import androidx.annotation.Nullable;

import com.celik.app11odev6sqlite.model.Contact;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    String create_table =   "CREATE TABLE contact"+
                            "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                            "name_surname TEXT NOT NULL ,"+
                            "phone_number TEXT NOT NULL)";

    SQLiteDatabase sqLiteDatabase;



    public DatabaseHelper(Context context) {
        super(context, "contact_database", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_table);
        this.sqLiteDatabase = sqLiteDatabase;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS contact");
        onCreate(sqLiteDatabase);
    }


    public void newContact(Contact contact) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name_surname",contact.getNameSurname());
        contentValues.put("phone_number",contact.getPhoneNumber());

        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert("contact",null,contentValues);

    }


    public ArrayList<Contact> getAllContact(){

        ArrayList<Contact> contact = new ArrayList<>();

        sqLiteDatabase = this.getReadableDatabase();

        String query = "SELECT * FROM contact";
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);


        if (cursor.moveToNext()) {
            do {
                String id = cursor.getString(0);
                String nameSurname = cursor.getString(1);
                String phoneNumber = cursor.getString(2);

                contact.add(new Contact(id,nameSurname,phoneNumber));
            }while (cursor.moveToNext());
        }

        cursor.close();
        return contact;

    }


    public void updateContact(Contact contact) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("name_surname",contact.getNameSurname());
        contentValues.put("phone_number",contact.getPhoneNumber());
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.update("contact",contentValues,"id=?",new String[]{contact.getId()});

    }


    public void deleteContact(String id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete("contact","id=?",new String[]{id});
    }

}
