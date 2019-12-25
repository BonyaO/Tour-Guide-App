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

        restaurants.add(new Establishment(getString(R.string.dreamland_res), getString(R.string.commercial_avenue), 2, 9, R.drawable.dreamlland_res));
        restaurants.add(new Establishment(getString(R.string.ctt_res), getString(R.string.commercial_avenue), 2, 6, R.drawable.ctt_res));
        restaurants.add(new Establishment(getString(R.string.alizanze_res), getString(R.string.old_town), 2, 4, R.drawable.alizanze_res));
        restaurants.add(new Establishment(getString(R.string.white_house_res), getString(R.string.commercial_avenue), 2, 4, R.drawable.res_general));
        restaurants.add(new Establishment(getString(R.string.le_biberon), getString(R.string.commercial_avenue), 2, 4, R.drawable.res_general));
        restaurants.add(new Establishment(getString(R.string.njeiforbi_res), getString(R.string.commercial_avenue), 2, 4, R.drawable.res_general));


        RestaurantAdapter myAdapter = new RestaurantAdapter(restaurants, new RestaurantAdapter.OnItemClickedListener() {
            @Override
            public void onItemClicked(Establishment hotel) {
                Toast.makeText(getContext(), R.string.item_clicked, Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        restaurantsRecView.setLayoutManager(manager);
        restaurantsRecView.setAdapter(myAdapter);
        restaurantsRecView.setItemAnimator(new DefaultItemAnimator());


        return rootView;
    }

}
