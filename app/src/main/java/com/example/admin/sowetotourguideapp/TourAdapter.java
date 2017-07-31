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
import com.example.admin.sowetotourguideapp.Mall;
import com.example.admin.sowetotourguideapp.Malls;
import com.example.admin.sowetotourguideapp.R;

import java.util.List;

/**
 * Created by Admin on 7/28/2017.
 */

public class TourAdapter extends ArrayAdapter<Malls> {

    private Activity context;
    private List<Malls> mallList;

    public TourAdapter(Activity context, List<Malls> mallList) {
        super(context,R.layout.list_item,mallList);

        this.context = context;
        this.mallList = mallList;

    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_item, null, true);
        ImageView imageView = (ImageView) listViewItem.findViewById(R.id.imageview_lv);
        TextView titleTextView = (TextView) listViewItem.findViewById(R.id.title_textview_lv);
        TextView descTextView = (TextView) listViewItem.findViewById(R.id.desc_textview_lv);
        TextView locTextView = (TextView) listViewItem.findViewById(R.id.loc_textview_lv);

        Malls mall = mallList.get(position);


        titleTextView.setText(mall.getMallName());
        descTextView.setText(mall.getMallAddress());
        locTextView.setText(mall.getMallId());


            String[] url = {"https://firebasestorage.googleapis.com/v0/b/sowetotourguideapp.appspot.com/o/malls%2Fjabulani.png?alt=media&token=e346871c-cae4-4f55-9c3d-17c0aff26c62",
                    "https://firebasestorage.googleapis.com/v0/b/sowetotourguideapp.appspot.com/o/malls%2Fmaponya.jpg?alt=media&token=1783058a-9416-42ee-a798-d03bbda865a2",
                    "https://firebasestorage.googleapis.com/v0/b/sowetotourguideapp.appspot.com/o/malls%2Fglen.jpeg?alt=media&token=323c35a9-f1fd-421e-8763-4a838157ffc7",
                    "https://firebasestorage.googleapis.com/v0/b/sowetotourguideapp.appspot.com/o/malls%2Fbara.jpg?alt=media&token=91918d0a-5821-40bb-86fb-ce1b86e74b70",
                    "https://firebasestorage.googleapis.com/v0/b/sowetotourguideapp.appspot.com/o/malls%2Fsquare.png?alt=media&token=c9cf2f78-e1cd-44c5-8d2b-b3194267d5c2"};
            Glide.with(context)
                    .load(url[position])
                    .into(imageView);



        return listViewItem;





    }
}
