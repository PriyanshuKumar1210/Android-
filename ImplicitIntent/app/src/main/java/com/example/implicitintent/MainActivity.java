package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        EditText editText = findViewById(R.id.edt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String url = editText.getText().toString();
       /*       Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+url));
                startActivity(intent);

*/
                Intent intent = new Intent(Intent.ACTION_SEND,Uri.parse("http://"+url));
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"Hello App");
                intent.setType("text/plain");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }

            }

        });
    }
}