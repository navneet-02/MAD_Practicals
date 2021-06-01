package com.example.dbapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends BaseAdapter {

    Activity activity;
    ArrayList<ServiceProvider> data;

    public MyArrayAdapter(Activity activity,ArrayList<ServiceProvider> data)
    {
        this.activity=activity;
        this.data=data;
    }

    @Override
    public int getCount()
    {
        return data.size();
    }

    @Override
    public Object getItem(int position)
    {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v=convertView;

        if(convertView==null)
        {
            LayoutInflater lf=(LayoutInflater) activity.getLayoutInflater();
            v=lf.inflate(R.layout.my_list_item,null);
        }

        TextView nameText=v.findViewById(R.id.nameText);
        TextView phoneText=v.findViewById(R.id.phoneText);
        TextView emailText=v.findViewById(R.id.emailText);
        TextView occupationText=v.findViewById(R.id.occupationText);

        ServiceProvider sp=data.get(position);
        nameText.setText(sp.getName());
        phoneText.setText(sp.getPhone());
        emailText.setText(sp.getEmail());
        occupationText.setText(sp.getOccupation());

        return v;
    }
}
