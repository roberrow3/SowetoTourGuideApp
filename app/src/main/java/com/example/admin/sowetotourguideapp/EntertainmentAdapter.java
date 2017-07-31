package com.example.admin.sowetotourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Admin on 7/31/2017.
 */

public class EntertainmentAdapter extends ArrayAdapter<Entertainments> {

    private Activity context;
    private List<Entertainments> entertainmentsList;

    public EntertainmentAdapter(Activity context, List<Entertainments> entertainmentsList) {
        super(context,R.layout.list_item,entertainmentsList);

        this.context = context;
        this.entertainmentsList = entertainmentsList;

    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_item, null, true);

        TextView titleTextView = (TextView) listViewItem.findViewById(R.id.title_textview_lv);
        ImageView imageView = (ImageView) listViewItem.findViewById(R.id.imageview_lv);
        TextView descTextView = (TextView) listViewItem.findViewById(R.id.desc_textview_lv);
        TextView locTextView = (TextView) listViewItem.findViewById(R.id.loc_textview_lv);

        Entertainments entertainment = entertainmentsList.get(position);


        titleTextView.setText(entertainment.getEntertainmentName());
        descTextView.setText(entertainment.getEntertainmentAddress());

        locTextView.setText(entertainment.getEntertainmentId());

        String[] url = {"https://firebasestorage.googleapis.com/v0/b/sowetotourguideapp.appspot.com/o/entertainment%2Fgift.jpg?alt=media&token=8ea953b0-793e-4c43-8746-ef31a9c24b04",
                "hhttps://firebasestorage.googleapis.com/v0/b/sowetotourguideapp.appspot.com/o/entertainment%2Fhis.jpg?alt=media&token=4262ab89-4795-460b-b2b1-b44a4a501a3e",
                "https://firebasestorage.googleapis.com/v0/b/sowetotourguideapp.appspot.com/o/entertainment%2Fstreet.jpg?alt=media&token=b644f048-e716-4620-964d-806fbae5a6c2",
                "https://firebasestorage.googleapis.com/v0/b/sowetotourguideapp.appspot.com/o/entertainment%2Flounge.jpg?alt=media&token=28ce46a9-2d6c-450d-9d0b-aa510045b767",
                "https://firebasestorage.googleapis.com/v0/b/sowetotourguideapp.appspot.com/o/entertainment%2Fkwa.jpg?alt=media&token=cb6bbcca-59b6-4a21-a4de-21f8661bf1fb",
                 "https://firebasestorage.googleapis.com/v0/b/sowetotourguideapp.appspot.com/o/entertainment%2Forlando.jpg?alt=media&token=831984a7-7431-4c7c-8ffd-2c2fa57093d5"};
        Glide.with(context)
                .load(url[position])
                .into(imageView);



        return listViewItem;

    }
}
