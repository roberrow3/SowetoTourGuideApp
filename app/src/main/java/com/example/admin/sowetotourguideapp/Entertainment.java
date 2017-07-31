package com.example.admin.sowetotourguideapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.solver.widgets.Snapshot;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.

 */
public class Entertainment extends Fragment {
    public static final String NAME = "Entertainment";
    private ListAdapter entertainmentAdapter;

    EditText editTextName;
    EditText editTextAddress;
    Button buttonAdd;

    DatabaseReference databaseEntertainment;

    ListView listViewMall;

    ArrayList<Entertainments> entertainmentList;


    public Entertainment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mall, container, false);
        databaseEntertainment = FirebaseDatabase.getInstance().getReference("entertainment");

        editTextName = (EditText) v.findViewById(R.id.editTextName);
        editTextAddress = (EditText) v.findViewById(R.id.editTextAdress);
        buttonAdd = (Button) v.findViewById(R.id.buttonAdd);

        listViewMall = (ListView) v.findViewById(R.id.listViewMall);

        entertainmentList = new ArrayList<>();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEntertainment();

            }
        });
        return v;
    }
    @Override
    public void onStart() {
        super.onStart();
        databaseEntertainment.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                entertainmentList.clear();


                for (DataSnapshot entertaimentSnapshot : dataSnapshot.getChildren()){
                    Entertainments entertainment = entertaimentSnapshot.getValue(Entertainments.class);

                    entertainmentList.add(entertainment);
                }

                EntertainmentAdapter adapter = new EntertainmentAdapter(getActivity(), entertainmentList);
                listViewMall.setAdapter(adapter);




            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void addEntertainment() {
        String name = editTextName.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();

        if (!TextUtils.isEmpty(name)){

            databaseEntertainment.push().getKey();

            String id = databaseEntertainment.push().getKey();

            Entertainments entertainment = new Entertainments(id, name, address);
            databaseEntertainment.child(id).setValue(entertainment);

            Toast.makeText(getActivity(), "Entertainment added", Toast.LENGTH_LONG);

        }else {
            Toast.makeText(getActivity(), "You should enter a name", Toast.LENGTH_SHORT);
        }

    }

}
