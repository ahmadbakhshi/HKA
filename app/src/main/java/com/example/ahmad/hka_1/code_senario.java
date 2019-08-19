package com.example.ahmad.hka_1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class code_senario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_senario);

        final EditText code1= (EditText) findViewById(R.id.code1);
        final EditText code2= (EditText) findViewById(R.id.code2);
        final EditText code3= (EditText) findViewById(R.id.code3);
        final EditText code4= (EditText) findViewById(R.id.code4);
        final EditText code5= (EditText) findViewById(R.id.code5);
        final EditText code6= (EditText) findViewById(R.id.code6);
        final EditText code7= (EditText) findViewById(R.id.code7);
        final EditText code8= (EditText) findViewById(R.id.code8);
        final EditText code9 = (EditText) findViewById(R.id.code9);
        final EditText code10 = (EditText) findViewById(R.id.code10);
        final EditText code11 = (EditText) findViewById(R.id.code11);
        final EditText code12 = (EditText) findViewById(R.id.code12);
        final EditText code13= (EditText) findViewById(R.id.code13);

        Button cancel= (Button) findViewById(R.id.button2);
        Button save= (Button) findViewById(R.id.button1);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database hlp = new database(code_senario.this);
                SQLiteDatabase database = hlp.getWritableDatabase();
                ContentValues values = new ContentValues();


                values.put("code", code1.getText().toString());


                database.insert("senario", null, values);
                database.close();
                hlp.close();
            }
        });
    }
}
