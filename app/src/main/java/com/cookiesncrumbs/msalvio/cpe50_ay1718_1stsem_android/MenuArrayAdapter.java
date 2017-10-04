package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by msalvio on 04/10/2017.
 */

public class MenuArrayAdapter extends ArrayAdapter {

    Context context;
    ArrayList<MenuItem> menuItems;

    public MenuArrayAdapter(Context context, ArrayList<MenuItem> menuItems) {
        super(context, -1, menuItems);

        this.context = context;
        this.menuItems = menuItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.menu_row_layout,parent, false);


        TextView menuItem = (TextView)v.findViewById(R.id.menu_item_tv);
        TextView menuPrice = (TextView)v.findViewById(R.id.menu_price_tv);

        DecimalFormat decimalFormat = new DecimalFormat("###,##0.00");

        MenuItem item = menuItems.get(position);

        menuItem.setText(item.getName());
        menuPrice.setText(decimalFormat.format(item.getPrice()));

        return v;

    }
}
