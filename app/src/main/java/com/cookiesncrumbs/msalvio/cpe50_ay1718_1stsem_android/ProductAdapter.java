package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product>{

    ArrayList<Product> products;
    Context context;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        super(context, -1, products);
        this.context = context;
        this.products = products;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.product_row,parent,false);

        TextView barcode_tv = (TextView) v.findViewById(R.id.barcode_tv);
        TextView product_tv = (TextView) v.findViewById(R.id.product_tv);
        TextView price_tv = (TextView) v.findViewById(R.id.price_tv);

        Product p = this.products.get(position);

        barcode_tv.setText(p.getBarcode());
        product_tv.setText(p.getName());
        price_tv.setText(String.valueOf(p.getPrice()));


        return v;
    }
}
