package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;


//import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

     TextView textView;
    Button pick_time;
    TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.view);
        pick_time = findViewById(R.id.click);
        timePicker.setIs24HourView(true);
        pick_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//              textView.setText(getCurrentTime());
                Calendar obj = Calendar.getInstance();
                int hours = obj.get(Calendar.HOUR_OF_DAY);
                int minute = obj.get(Calendar.MINUTE) ;

                TimePickerDialog timepickerdialog = new TimePickerDialog(MainActivity.this, R.style.Theme_AppCompat_Dialog, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        c.set(Calendar.MINUTE, minute);
                        c.setTimeZone (TimeZone.getDefault());
//                        SimpleDateFormat format = new SimpleDateFormat(pattern : "k:mm a");
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
                        String time = format.format(c.getTime());
                        TimeTextView.setText (time);




                    }
                },hours ,minute, is24HourView : true) ;
                timepickerdialog.show();
            }
        });

    }
/*
    public String getCurrentTime(){
        String currentTime="Current Time: "+timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute();
        return currentTime;
    }*/



    }
}