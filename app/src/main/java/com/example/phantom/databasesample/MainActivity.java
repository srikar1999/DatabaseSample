package com.example.phantom.databasesample;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class MainActivity extends AppCompatActivity {
     EditText roll,name,phone;Button b,r;
     SQLiteDatabase sdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         roll=(EditText)findViewById(R.id.editText);
         name=(EditText)findViewById(R.id.editText2);
         phone=(EditText)findViewById(R.id.editText3);
         b =(Button)findViewById(R.id.button);
         r =(Button)findViewById(R.id.button2);
         sdb =openOrCreateDatabase("SREE", MODE_PRIVATE, null);
         sdb.execSQL("create table if not exists CSE(Rollno varchar(10),Name varchar(15),Phone varchar(10))");
          b.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  String sroll=roll.getText().toString();
                  String sname=name.getText().toString();
                  String sphone=phone.getText().toString();
                  sdb.execSQL("insert into CSE values('"+sroll+"','"+sname+"','"+sphone+"')");
                  Toast.makeText(getApplicationContext(), "Successfully added", Toast.LENGTH_SHORT).show();
              }
          });
          r.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent it =new Intent(MainActivity.this,SecondActivity.class);
                  startActivity(it);
              }
          });
    }
}
