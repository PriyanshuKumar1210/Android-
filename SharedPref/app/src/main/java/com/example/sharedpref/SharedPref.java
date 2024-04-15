package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.jar.Attributes;

public class SharedPref extends AppCompatActivity {
    EditText name, fname;
    Button save, Retrive;
    TextView tv;
    String data="NONE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        name=findViewById(R.id.name);
        fname=findViewById(R.id.Fname);
        tv=findViewById(R.id.tv);
        save=findViewById(R.id.Save);
        Retrive=findViewById(R.id.Retrive);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Father=fname.getText().toString();
                String Name=name.getText().toString();
                SharedPreferences mysharedPref = getSharedPreferences(data,MODE_PRIVATE);
                SharedPreferences.Editor myedit = mysharedPref.edit();
                myedit.putString("FUll_NAME",Name);
                myedit.putString("Father_Name",Father);
                myedit.commit();

            }
        });
        Retrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences mypref = getSharedPreferences(data,MODE_PRIVATE);
                String Name =mypref.getString("FUll_NAME",null);
                String fname = mypref.getString("Father_Name", null);
                tv.setText("Name:"+Name+"FNAME:" +fname);


            }
        });
    }
}