package com.example.admin.sowetotourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin.sowetotourguideapp.School;
import com.example.admin.sowetotourguideapp.Schools;
import com.example.admin.sowetotourguideapp.R;
import java.util.List;

/**
 * Created by Admin on 7/31/2017.
 */

public class SchoolAdapter extends ArrayAdapter<Schools> {

    private Activity context;
    private List<Schools> schoolsList;

    public SchoolAdapter(Activity context, List<Schools> schoolList) {
        super(context,R.layout.list_item,schoolList);

        this.context = context;
        this.schoolsList = schoolList;

    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_item, null, true);

        TextView titleTextView = (TextView) listViewItem.findViewById(R.id.title_textview_lv);
        TextView descTextView = (TextView) listViewItem.findViewById(R.id.desc_textview_lv);
        TextView locTextView = (TextView) listViewItem.findViewById(R.id.loc_textview_lv);

        Schools school = schoolsList.get(position);


        titleTextView.setText(school.getSchoolName());
        descTextView.setText(school.getSchoolAddress());

        locTextView.setText(school.getSchoolId());



        return listViewItem;

    }
}
