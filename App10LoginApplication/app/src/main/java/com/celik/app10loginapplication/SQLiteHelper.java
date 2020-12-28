package com.celik.app10loginapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

//SQLite database oluşturur,günceller,
public class SQLiteHelper extends SQLiteOpenHelper {

    SQLiteDatabase database;


    public SQLiteHelper(@Nullable Context context) {
        super(context, "dbUSERS", null, 1);
    }

    
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //add USERS table to sqLiteDatabase
        String createStatement = "CREATE TABLE USERS" +
                "(ID INTEGER PRIMARY KEY ," +
                "USERNAME TEXT NOT NULL," +
                "PASSWORD TEXT NOT NULL)";

        sqLiteDatabase.execSQL(createStatement);
        this.database = sqLiteDatabase;

    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //USERS tablosunu silme ve yeniden oluşturma
        String upgradeStatement = "DROP TABLE IF EXISTS USERS";
        sqLiteDatabase.execSQL(upgradeStatement);
        this.onCreate(sqLiteDatabase);

    }


    //USERS tablosuna kayı ekler.Ekleme başarılı olursa true değer döner.
    public boolean addUser(String userName,String password) {
        //veritabanına yazma izni
        database = this.getWritableDatabase();

        //veritabanına yazılacak veriyi hazırlama
        ContentValues values = new  ContentValues();
        values.put("USERNAME",userName);
        values.put("PASSWORD",password);

        //veritabanına veri yazma
        long result = database.insert("USERS",null,values);

        //veritabanını kapatma
        database.close();

        //Kayıt başarılı mı ?
        if (result == -1) {
            return false;
        } else {
            return true;
        }


    }


    //USERS tablosunda userName parametresine göre arama yapar.Eğer kullanıcı var ise password döner.
    public String findUser(String userName) {

        //okuma izni
        database = this.getReadableDatabase();

        //verilen kullanıcı adına göre şifreyi çekme
        String searchStatement = "SELECT PASSWORD FROM USERS WHERE USERNAME="+ "'" + userName +"'";
        Cursor cursor = database.rawQuery(searchStatement,null);

        //Kayıt Çekildi mi?
        if (cursor.moveToFirst()) {
            database.close();
            return cursor.getString(0);
        } else {
            database.close();
            return "";
        }

    }


    //Veritabanında bulunan tüm USERS kayıtlarının USERNAME stununu arraylist olarak döner.
    public ArrayList<String> listUsers() {

        ArrayList<String> users = new ArrayList<>();

        database = this.getReadableDatabase();

        String query = "SELECT * FROM USERS";
        Cursor cursor = database.rawQuery(query,null);


        if (cursor.moveToNext()) {
            do {
                users.add(cursor.getString(1));
            }while (cursor.moveToNext());
        }


        database.close();
        return users;

    }
}
