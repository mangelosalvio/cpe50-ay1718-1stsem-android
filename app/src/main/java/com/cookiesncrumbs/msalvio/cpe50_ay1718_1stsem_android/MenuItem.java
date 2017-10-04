package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

/**
 * Created by msalvio on 04/10/2017.
 */

public class MenuItem {
    private int _id;
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public MenuItem(int _id, String name, double price) {
        this._id = _id;
        this.name = name;
        this.price = price;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
