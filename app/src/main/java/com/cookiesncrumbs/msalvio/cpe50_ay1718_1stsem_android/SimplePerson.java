package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

/**
 * Created by msalvio on 02/10/2017.
 */

public class SimplePerson {
    private int _id;
    private String name;

    public SimplePerson(String name) {
        this.name = name;
    }

    public SimplePerson(int _id, String name) {
        this._id = _id;
        this.name = name;
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

    @Override
    public String toString() {
        return name;
    }
}
