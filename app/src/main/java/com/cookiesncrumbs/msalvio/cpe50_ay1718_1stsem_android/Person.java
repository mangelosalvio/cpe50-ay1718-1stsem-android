package com.cookiesncrumbs.msalvio.cpe50_ay1718_1stsem_android;

/**
 * Created by msalvio on 18/09/2017.
 */

public class Person {

    private String name, address, contactNo;

    public Person(String name, String address, String contactNo) {
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
