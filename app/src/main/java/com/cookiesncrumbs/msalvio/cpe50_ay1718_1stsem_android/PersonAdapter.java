package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msalvio on 18/09/2017.
 */

public class PersonAdapter extends ArrayAdapter<Person> {

    Context context;
    ArrayList<Person> persons;

    public PersonAdapter(Context context, ArrayList<Person> persons) {
        super(context, -1, persons);
        this.context = context;
        this.persons = persons;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.person_row_layout,parent,false);

        TextView nameTextView = (TextView) v.findViewById(R.id.name_tv);
        TextView addressTextView = (TextView) v.findViewById(R.id.address_tv);
        TextView contactTextView = (TextView) v.findViewById(R.id.contact_no_tv);

        Person p = persons.get(position);
        nameTextView.setText(p.getName());
        addressTextView.setText(p.getAddress());
        contactTextView.setText(p.getContactNo());


        return v;
    }
}
