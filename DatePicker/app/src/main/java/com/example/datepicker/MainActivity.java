package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    Button button;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datePicker);
        button = findViewById(R.id.button1);
        text = findViewById(R.id.edt1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day,month,year;
                day = String.valueOf(datePicker.getDayOfMonth());
                month = String.valueOf(datePicker.getMonth()+1);
                year = String.valueOf(datePicker.getYear());

                if(day.isEmpty() && month.isEmpty() && year.isEmpty()){
                    Toast.makeText(MainActivity.this,"choose date",Toast.LENGTH_SHORT).show();
//                    text.setText();
                }
                else {
                    text.setText(day+"/"+month+"/"+year);
                }
//                Toast.makeText(MainActivity.this,day + "/"+month+"/"+year, Toast.LENGTH_LONG).show();

            }
        });

    }
}