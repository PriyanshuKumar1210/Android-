package com.example.sharecprefances;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PrivateKey;


public class RegisterActivity extends AppCompatActivity {

    EditText name;
    EditText password;
    EditText repassword;
    EditText emailid;
    EditText phone;
    Button submit;

    private  final String Creadantial="my_pref";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name =findViewById(R.id.fname);
        emailid=findViewById(R.id.uid);
        password=findViewById(R.id.password);
        repassword=findViewById(R.id.Repassword);
        phone=findViewById(R.id.Phone);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password0 =password.getText().toString();
                String rePassword=repassword.getText().toString();
                String userid = emailid.getText().toString();
                String fname= name.getText().toString();
                String PhoneNumber=phone.getText().toString();
                if(password0.equals(rePassword) && password0 != null && rePassword !=null)
                {
                    SharedPreferences credintials =getSharedPreferences(Creadantial, MODE_PRIVATE);
                    SharedPreferences.Editor editor = credintials.edit();
                    editor.putString("Userid",userid);
                    editor.putString("password",password0);
                    editor.commit();
                    Toast.makeText(RegisterActivity.this,"Register Sucessfull",Toast.LENGTH_LONG).show();
                    RegisterActivity.this.finish();
                }


            }
        });
    }
}