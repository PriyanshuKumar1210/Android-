package com.example.contextmenu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

     Button text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.button);
        registerForContextMenu(text);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_example, menu);
    }
/*
    public boolean onContextItemSelected(MenuItem item) {
        int id=item.getItemId();
      /*  switch (id) {
            case R.id.enq:
                Toast.makeText(this, "Option 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.abt:
                Toast.makeText(this, "Option 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
                */
/*
        if(id==R.id.enq){
            Toast.makeText(this, "Enquiry selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id==R.id.abt) {
            Toast.makeText(this, "About us selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id==R.id.cond) {
            Toast.makeText(this, "Terms & condition selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id==R.id.log) {
            Toast.makeText(this, "Logout selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }*/
}