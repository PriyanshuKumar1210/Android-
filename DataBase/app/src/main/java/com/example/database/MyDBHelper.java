package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDBHelper  extends SQLiteOpenHelper {
private static final String name="Contact";
private static final int version=1;
private static final String Table_Contact="Contact";
    private static final String Key_ID="id";
    private static final String Key_Name="name";
    private static final String Key_Phone_no="Phone_no";
    public MyDBHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+ Table_Contact +
                "(" +Key_ID + " INTEGER, PRIMARYKEY AUTOICREMENT," + Key_Name +"TEXT,"+Key_Phone_no+"TEXT"+")");


    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Contact);

    }
    public void addContact(String name, String PhoneNo){

        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cn = new ContentValues();
        cn.put(Key_Name,name);
        cn.put(Key_Phone_no,PhoneNo);
        db.insert(Table_Contact,null,cn);
    }
    public ArrayList<Contact> FetchData()
    {
        SQLiteDatabase view=this.getReadableDatabase();
        Cursor cursor= view.rawQuery("SELECT * FROM "+Table_Contact,null);

        ArrayList<Contact> arrayList =new ArrayList<>();
        while (cursor.moveToNext())
        {
            Contact cn =new Contact();
            cn.id =cursor.getInt(0);
            cn.Name=cursor.getString(1);
            cn.Phone_no=cursor.getString(2);
            arrayList.add(cn);
        }

        return arrayList;
    }
}
