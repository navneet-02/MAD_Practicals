 package com.example.dbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


 public class MainActivity extends AppCompatActivity implements View.OnClickListener {

     EditText nameText, phoneText, emailText, occupationText, passText;
     Button submitButton, viewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText=findViewById(R.id.nameText);
        phoneText=findViewById(R.id.phoneText);
        emailText=findViewById(R.id.emailText);
        occupationText=findViewById(R.id.occupationText);
        passText=findViewById(R.id.passText);
        submitButton=findViewById(R.id.submit);
        viewButton=findViewById(R.id.view);

        submitButton.setOnClickListener(this);
        viewButton.setOnClickListener(this);
    }

     @Override
     public void onClick(View v) {

         if (v.getId() == R.id.submit) {
             MyDBHelper ob = new MyDBHelper(this);
             SQLiteDatabase db = ob.getWritableDatabase();
             ContentValues cv = new ContentValues();
             cv.put("name", nameText.getText().toString());
             cv.put("phone", phoneText.getText().toString());
             cv.put("email", emailText.getText().toString());
             cv.put("occupation", occupationText.getText().toString());
             cv.put("password", passText.getText().toString());

             long i = db.insert("spdetails", null, cv);
             if (i > 0) {
                 Toast.makeText(this, "Record Inserted!", Toast.LENGTH_SHORT).show();
                 nameText.setText("");
                 phoneText.setText("");
                 emailText.setText("");
                 occupationText.setText("");
                 passText.setText("");
             }

             else {
                 Toast.makeText(this, "Record not inserted", Toast.LENGTH_SHORT).show();
             }
         }
         else if (v.getId() == R.id.view) {
             Intent intent = new Intent(this, DemoCustomList.class);
             startActivity(intent);
         }

     }
     }
