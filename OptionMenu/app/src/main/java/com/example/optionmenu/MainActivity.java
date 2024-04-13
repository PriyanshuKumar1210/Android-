package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.option_menu, menu);
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
   public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.item1){
            Toast.makeText(this, "Item1 Selected", Toast.LENGTH_SHORT).show();
        } else if (id==R.id.item2) {
            Toast.makeText(this, "Item2 Selected", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
//
//        return true;
    }
}