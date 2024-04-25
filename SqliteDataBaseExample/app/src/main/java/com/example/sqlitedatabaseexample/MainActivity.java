package com.example.sqlitedatabaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       mydatabase dataBase = new mydatabase(this);

       dataBase.addContact(1,"Priyanshu","9123485695");
        dataBase.addContact(2,"Saurav","7423485695");

    //    ArrayList<ContactModel> arrcontacts = dataBase.fetchData();
    //    for(int i=0; i<arrcontacts.size(); i++)
     //       Log.d(  "CONTACT_INFO", "Name: "+arrcontacts.get(i).name + ",Phone No : "+arrcontacts.get(i).phone_no);
   }

    }

