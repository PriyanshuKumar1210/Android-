package com.example.sqlitedatabaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

/* ------ we create the another java class to reduce the redundancy --------------- */
/* ------ we need to extend the java code for use the sqlite database
        * it provides to method onCreate() or onUpgrade()
------------- */
public class MyDataBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Contact";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "Table_Contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String PHONE_NO = "phone_number";


    public MyDataBase(@Nullable Context context) {

        super(context, DATABASE_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//  Creating the table

       /* String create_table = "CREATE TABLE " + DATABASE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + "TEXT," + PHONE_NO + "TEXT" + ")";
        db.execSQL(create_table);*/
        db.execSQL("CREATE TABLE "+"Contact"+
                        "(" + KEY_ID+" INTEGER, PRIMARYKEY AUTOICREMENT,"+ KEY_NAME+"TEXT,"+PHONE_NO+"TEXT"+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + "Contact");
        onCreate(db);
    }

    public void addContact(int id,String name,String phone_number){
        SQLiteDatabase db = this.getWritableDatabase();
            // used for making the SQLiteDatabase object

        ContentValues values = new ContentValues();
        values.put(KEY_ID,id);
        values.put(KEY_NAME,name);
        values.put(PHONE_NO,phone_number);
        db.insert(TABLE_NAME,null,values);

        db.close();
    }

//selecting the table

    public ArrayList<ContactModel> fetchData() {
        SQLiteDatabase db = this.getReadableDatabase();

        //we used cursor for select query
        Cursor cursor = db.rawQuery(" SELECT * FROM " + "Contact", null);

        ArrayList<ContactModel> arrayList = new ArrayList<>();
        while (cursor.moveToNext()) {
            ContactModel model = new ContactModel();
            model.id = cursor.getInt(0);
            model.name = cursor.getString(1);
            model.phone_no = cursor.getString(2);
            arrayList.add(model);
            cursor.close();
        }
        return arrayList;
    }
}
