package com.example.database;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText name,phone;
    TextView show;
    Button insert,view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        show=findViewById(R.id.tv);
        insert=findViewById(R.id.insert);
        view=findViewById(R.id.view);

        MyDBHelper dbHelper = new MyDBHelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name=name.getText().toString();
                String Phone=phone.getText().toString();
                dbHelper.addContact(Name,Phone);
            }
        });

       view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ArrayList<Contact> arr =dbHelper.FetchData();
               for (int i =0; i<arr.size();i++)
               {
                   show.setText("Name"+arr.get(i).Name + "Phone No "+arr.get(i).Phone_no);
               }


            }
        });
    }
}