package com.celik.app11odev6sqlite.model;

import java.io.Serializable;

public class Contact implements Serializable {

    private String id;
    private String nameSurname;
    private String phoneNumber;



    public Contact(String id, String nameSurname, String phoneNumber) {
        this.id = id;
        this.nameSurname = nameSurname;
        this.phoneNumber = phoneNumber;
    }


    public Contact(String nameSurname, String phoneNumber) {
        this.nameSurname = nameSurname;
        this.phoneNumber = phoneNumber;
    }


    public String getId() {
        return id;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }



    @Override
    public String toString() {
        return nameSurname;
    }


}
