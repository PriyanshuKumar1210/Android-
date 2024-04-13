package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Used to connect the xml file to java

        EditText edt1,edt2;
        Button button1;
        TextView result;

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        button1 = findViewById(R.id.button1);
        result = findViewById(R.id.result);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(edt1.getText().toString());
                int num2 = Integer.parseInt(edt2.getText().toString());

                double total = num1+num2;

                String finalresult = Double.toString(total);
                result.setText(finalresult);

            }
        });

/*
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtweight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeight In.getText().toString());
                int totalIn = ft*12+ in;
                double totalCm = totalIn*2.53;
                double totalM = totalCm/100;
                double bmi = wt/(totalM*totalM);
                if (bmi>25){
                    txtResult.setText("You're Overweight!");
                } else if (bmi<18) {
                    txtResult.setText("You're UnderWeight");
                } else {
                    txtResult.setText("You're Healthy");
                }
*/
    }
}