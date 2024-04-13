package com.example.sharecprefances;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class LoginActivity extends AppCompatActivity {
    EditText Userid;
    EditText password;
    Button signin;
    Button Signup;
    private  final String Creadantial="my_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Userid = findViewById(R.id.uid);
        password= findViewById(R.id.password);
        Signup=findViewById(R.id.signup);
        signin=findViewById(R.id.signin);
        /*
         * For Signup/Register User
         */
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }

        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences credantial = getSharedPreferences(Creadantial,MODE_PRIVATE);
                String username=credantial.getString("Userid",null);
                String getpassword=credantial.getString("password",null);
                String uname=Userid.getText().toString();
                String passwd=password.getText().toString();
                if(uname != null &&  uname.toString().equals(username) )
                {
                    if(passwd != null && passwd.toString().equals(getpassword))
                    {
                        Userid.setText(username);
                        password.setText(getpassword);
                        Toast.makeText(LoginActivity.this,"Login Sucessfull",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(LoginActivity.this,"Login Faild",Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(LoginActivity.this,"Login Faild",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}