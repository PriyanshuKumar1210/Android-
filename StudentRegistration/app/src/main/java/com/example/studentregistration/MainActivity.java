package com.example.student_login;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btninsert = (Button)findViewById(R.id.btn_submit);
        btninsert.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                EditText name = (EditText)findViewById(R.id.et_name);
                EditText reg_no = (EditText)findViewById(R.id.et_Reg);
                EditText email = (EditText)findViewById(R.id.et_email);
                EditText mobile = (EditText)findViewById(R.id.et_mob);

                if( name.getText().toString().length() == 0 )
                {
                    name.setError( "Name is required!" );
                    Toast.makeText(getApplicationContext(), "Missing Name.", Toast.LENGTH_SHORT).show();
                    if(reg_no.getText().toString().length() == 0) {
                        reg_no.setError("Reg no. is required");
                        Toast.makeText(getApplicationContext(), "Missing Reg. no.", Toast.LENGTH_SHORT).show();
                        if (email.getText().toString().length() == 0) {
                            email.setError("Email_Id is required!");
                            Toast.makeText(getApplicationContext(), "Missing Email_Id no.", Toast.LENGTH_SHORT).show();
                            if (mobile.getText().toString().length() == 0) {
                                mobile.setError("Enter mobile no.!");
                                Toast.makeText(getApplicationContext(), "Missing mobile no.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Registation Successfull", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}