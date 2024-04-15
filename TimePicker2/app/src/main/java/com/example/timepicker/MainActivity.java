package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Button changetime;
    TimePicker picktime;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changetime = findViewById(R.id.button1);
        picktime = findViewById(R.id.timePicker);
        text = findViewById(R.id.text1);

        picktime.setIs24HourView(true);

        changetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(getCurrentTime());
            }
        });
    }

    public String getCurrentTime(){
          String currentTime = "Current Time : "+picktime.getCurrentHour()+" : "+picktime.getCurrentMinute();
          return currentTime;
    }
}