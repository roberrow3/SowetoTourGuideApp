package com.example.admin.sowetotourguideapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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


/**
 * A simple {@link Fragment} subclass.

 */
public class Restaurant extends Fragment {

    public static final String NAME = "Restaurants";
    private ListAdapter restaurantAdapter;

    EditText editTextName;
    EditText editTextAddress;
    Button buttonAdd;

    DatabaseReference databaseRestaurant;

    ListView listViewMall;

    ArrayList<Restaurants> restaurantList;


    public Restaurant() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mall, container, false);
        databaseRestaurant = FirebaseDatabase.getInstance().getReference("restaurant");

        editTextName = (EditText) v.findViewById(R.id.editTextName);
        editTextAddress = (EditText) v.findViewById(R.id.editTextAdress);
        buttonAdd = (Button) v.findViewById(R.id.buttonAdd);

        listViewMall = (ListView) v.findViewById(R.id.listViewMall);

        restaurantList = new ArrayList<>();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRestaurant();

            }
        });
        return v;
    }
    @Override
    public void onStart() {
        super.onStart();
        databaseRestaurant.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                restaurantList.clear();


                for (DataSnapshot restaurantSnapshot : dataSnapshot.getChildren()){
                    Restaurants restaurant = restaurantSnapshot.getValue(Restaurants.class);

                    restaurantList.add(restaurant);
                }

                RestaurantAdapter adapter = new RestaurantAdapter(getActivity(), restaurantList);
                listViewMall.setAdapter(adapter);




            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void addRestaurant() {
        String name = editTextName.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();

        if (!TextUtils.isEmpty(name)){

            databaseRestaurant.push().getKey();

            String id = databaseRestaurant.push().getKey();

            Restaurants restaurant = new Restaurants(id, name, address);
            databaseRestaurant.child(id).setValue(restaurant);

            Toast.makeText(getActivity(), "Restaurant added", Toast.LENGTH_LONG);

        }else {
            Toast.makeText(getActivity(), "You should enter a name", Toast.LENGTH_SHORT);
        }

    }



}
