package com.example.phantom.databasesample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    EditText e;
    Button search;
    TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        e =(EditText)findViewById(R.id.editText4);
        search =(Button)findViewById(R.id.button3);
        t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView2);
        t3=(TextView)findViewById(R.id.textView3);

        final SQLiteDatabase sdb=openOrCreateDatabase("SREE", MODE_PRIVATE, null);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s =e.getText().toString();
                Cursor c = sdb.rawQuery("select * from CSE where Rollno ='"+s+"' " ,null);
                if(c!=null)
                {
                    c.moveToFirst();
                    do {
                        int a =c.getColumnIndex("Rollno");
                        int b =c.getColumnIndex("Name");
                        int d =c.getColumnIndex("Phone");

                        )


                        String a1=c.getString(a);
                        String a2=c.getString(b);
                        String a3=c.getString(d);

                        t1.setText(a1);
                        t2.setText(a2);
                        t3.setText(a3);
                    }while(c.moveToNext());
                }

            }
        });
    }
}
