package com.example.admin.sowetotourguideapp;

/**
 * Created by Admin on 7/28/2017.
 */

public class Restaurants {

    String restaurantId;
    String restaurantName;
    String restaurantAddress;


    public Restaurants() {

    }

    public Restaurants(String restaurantId, String restaurantName, String restaurantAddress) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;

    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;

    }
}
