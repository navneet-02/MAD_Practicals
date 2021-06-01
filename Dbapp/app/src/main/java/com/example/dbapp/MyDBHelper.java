package com.example.dbapp;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

    public MyDBHelper(Activity activity)
    {
        super(activity,"MyDB.db",null,1);
    }


    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL("create table spdetails(spID integer ,name text,phone text,email text,occupation text,password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
