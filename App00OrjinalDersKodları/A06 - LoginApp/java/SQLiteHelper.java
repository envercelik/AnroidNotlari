package ders.yasin.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {
    public final static String DATABASE_NAME="USER.DB";
    public final static String TABLE_NAME="USERS";
    public final static String COL_ID="ID";
    public final static String COL_USERNAME="USERNAME";
    public final static String COL_NAME="NAME";
    public final static String COL_PASSWORD="PASSWORD";

    SQLiteDatabase database;

    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String TABLE_CREATE="CREATE TABLE "+TABLE_NAME+ "(ID INTEGER PRIMARY KEY, USERNAME TEXT NOT NULL, NAME TEXT, PASSWORD TEXT NOT NULL)";
        sqLiteDatabase.execSQL(TABLE_CREATE);
        this.database=sqLiteDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String UPGRADE_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME;
        sqLiteDatabase.execSQL(UPGRADE_TABLE);
        this.onCreate(sqLiteDatabase);
    }

    public boolean insertUser(String userName, String name, String password) {
       this.database=this.getWritableDatabase();
       String id_Query="SELECT * FROM "+TABLE_NAME;
       Cursor cursor=database.rawQuery(id_Query,null);
       int count=cursor.getCount();

        ContentValues value=new ContentValues();
        value.put(COL_ID,count+1);
        value.put(COL_NAME,name);
        value.put(COL_USERNAME,userName);
        value.put(COL_PASSWORD,password);

        Long result=database.insert(TABLE_NAME,null,value);
        database.close();
        if(result==-1)
            return false;
        else
            return true;

    }

    public String findUser(String userName) {
        database=this.getReadableDatabase();
        String query="SELECT * FROM "+TABLE_NAME+" WHERE USERNAME='"+userName+"'";
        Cursor cursor=database.rawQuery(query,null);
        if(cursor.moveToFirst()){
            database.close();
            return cursor.getString(3);
        } else{
            return "NOT FOUND";
        }
    }

    public ArrayList<String> getAllUsers() {
        database=this.getReadableDatabase();
        String query="SELECT * FROM "+TABLE_NAME;
        Cursor cursor=database.rawQuery(query,null);
        ArrayList<String> userNames=new ArrayList<String>();

        if(cursor.moveToFirst()){
            do{
                userNames.add(cursor.getString(1));
            }while(cursor.moveToNext());
        }
        database.close();
        return  userNames;
    }
}
