package com.example.admin.sowetotourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 7/31/2017.
 */

public class RestaurantAdapter extends ArrayAdapter<Restaurants> {

    private Activity context;
    private List<Restaurants> restaurantsList;

    public RestaurantAdapter(Activity context, List<Restaurants> restaurantsList) {
        super(context,R.layout.list_item,restaurantsList);

        this.context = context;
        this.restaurantsList = restaurantsList;

    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_item, null, true);

        TextView titleTextView = (TextView) listViewItem.findViewById(R.id.title_textview_lv);
        TextView descTextView = (TextView) listViewItem.findViewById(R.id.desc_textview_lv);
        TextView locTextView = (TextView) listViewItem.findViewById(R.id.loc_textview_lv);

        Restaurants restaurant = restaurantsList.get(position);


        titleTextView.setText(restaurant.getRestaurantName());
        descTextView.setText(restaurant.getRestaurantAddress());

        locTextView.setText(restaurant.getRestaurantId());



        return listViewItem;

    }
}
