package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

/**
 * Created by msalvio on 22/09/2017.
 */

public class Product {

    private int _id;
    private String name, barcode;
    private double price;

    public Product(String name, String barcode, double price) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
    }

    public String getName() {
        return name;
    }


    public Product(int _id, String name, String barcode, double price) {
        this._id = _id;
        this.name = name;
        this.barcode = barcode;
        this.price = price;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", barcode='" + barcode + '\'' +
                ", price=" + price +
                '}';
    }
}
