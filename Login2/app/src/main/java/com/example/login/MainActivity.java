package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText Email;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Linking the xml file

/* ---------- Showing a toast message when user click on login button ----------------*/

        login = findViewById(R.id.Btn_login);
        Email = findViewById(R.id.Email);
        password = findViewById(R.id.password);//bug
        String strmail = Email.getText().toString();
        String strpswd = password.getText().toString();

/* -------------    click listener event happen when user click on login button -----------*/




            login.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    //checking the password

                    if (Email.getText().toString().equals("Admin") && password.getText().toString().equals("Priyanshu@12")) {
                        Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_LONG).show();
                        //Toast message code

                        /* ---------------------- Adding a Explicit intent ----------------*/

                        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                        startActivity(intent);
                    }
                 else if(strmail.isEmpty() && strpswd.isEmpty()){
                        Toast.makeText(getApplicationContext(),"Please Enter Valid Details",Toast.LENGTH_LONG).show();
                }

                    else {
                        Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
                        //Toast message code
                    }

                }
            });

    }
}