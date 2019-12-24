package com.bonya.tourguide.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bonya.tourguide.R;
import com.bonya.tourguide.adapters.HotelAdapter;
import com.bonya.tourguide.adapters.RestaurantAdapter;
import com.bonya.tourguide.models.Establishment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {
    ArrayList<Establishment> restaurants = new ArrayList<>();


    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_restaurants, container, false);

        RecyclerView restaurantsRecView = rootView.findViewById(R.id.restaurants_rec_view);

        restaurants.add(new Establishment("Dreamland Restauarant", "Cormercial Avenue", 2, 9, R.drawable.dreamlland_res));
        restaurants.add(new Establishment("CTT Restauarant", "Cormercial Avenue", 2, 6, R.drawable.ctt_res));
        restaurants.add(new Establishment("Alizanze Restauarant", "Old Town", 2, 4, R.drawable.alizanze_res));
        restaurants.add(new Establishment("White House Restauarant", "Cormercial Avenue", 2, 4, R.drawable.white_house_res));
        restaurants.add(new Establishment("Le Biberon", "Cormercial Avenue", 2, 4, R.drawable.res_general));
        restaurants.add(new Establishment("Njeiforbi Restauarant", "Cormercial Avenue", 2, 4, R.drawable.res_general));


        RestaurantAdapter myAdapter = new RestaurantAdapter(restaurants, new RestaurantAdapter.OnItemClickedListener() {
            @Override
            public void onItemClicked(Establishment hotel) {
                Toast.makeText(getContext(), "Item Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        restaurantsRecView.setLayoutManager(manager);
        restaurantsRecView.setAdapter(myAdapter);
        restaurantsRecView.setItemAnimator(new DefaultItemAnimator());


        return rootView;
    }

}
