package com.example.dbapp;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;
import android.os.Bundle;
import java.util.ArrayList;

public class DemoCustomList extends AppCompatActivity {

    ListView list;
    ArrayList<ServiceProvider> data=new ArrayList<ServiceProvider>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_custom_list);

        list=findViewById(R.id.mycustomlist);

        MyDBHelper dbhelper=new MyDBHelper(this);
        SQLiteDatabase db=dbhelper.getReadableDatabase();

        Cursor cr= db.rawQuery("select * from spdetails",null);

        while(cr.moveToNext()) {
            String name = cr.getString(1);
            String phone = cr.getString(2);
            String email = cr.getString(3);
            String occupation = cr.getString(4);

            ServiceProvider sp = new ServiceProvider();
            sp.setName(name);
            sp.setPhone(phone);
            sp.setEmail(email);
            sp.setOccupation(occupation);

            data.add(sp);
        }

        MyArrayAdapter adapter=new MyArrayAdapter(this,data);
        list.setAdapter(adapter);
    }
}
