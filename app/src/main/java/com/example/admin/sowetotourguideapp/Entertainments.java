package com.example.admin.sowetotourguideapp;

/**
 * Created by Admin on 7/28/2017.
 */

public class Entertainments {

    String entertainmentId;
    String entertainmentName;
    String entertainmentAddress;


    public Entertainments() {

    }

    public Entertainments(String  entertainmentId, String entertainmentName, String entertainmentAddress) {
        this.entertainmentId = entertainmentId;
        this.entertainmentName = entertainmentName;
        this.entertainmentAddress = entertainmentAddress;

    }

    public String getEntertainmentId() {
        return entertainmentId;
    }

    public String getEntertainmentName() {
        return entertainmentName;
    }

    public String getEntertainmentAddress() {
        return entertainmentAddress;

    }
}
