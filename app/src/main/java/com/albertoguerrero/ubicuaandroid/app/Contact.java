package com.albertoguerrero.ubicuaandroid.app;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by albertoguerreromartin on 26/02/14.
 */
public class Contact
{
    private String name;
    private String phoneNumber;
    private String address;
    private String notes;

    public Contact(String name, String phoneNumber, String address, String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
