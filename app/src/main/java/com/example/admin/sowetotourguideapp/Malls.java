package com.example.admin.sowetotourguideapp;

/**
 * Created by Admin on 7/28/2017.
 */

public class Malls {
    String mallId;
    String mallName;
    String mallAddress;
    String mallImage;


    public Malls(String id, String name, String address) {

    }

    public Malls(String mallId, String mallName, String mallAddress, String mallImage) {
        this.mallId = mallId;
        this.mallName = mallName;
        this.mallAddress = mallAddress;
        this.mallImage = mallImage;

    }

    public String getMallId() {
        return mallId;
    }

    public String getMallName() {
        return mallName;
    }

    public String getMallAddress() {
        return mallAddress;

    }

    public Malls() {
    }

    public String getMallImage() {
        return mallImage;
    }
}
