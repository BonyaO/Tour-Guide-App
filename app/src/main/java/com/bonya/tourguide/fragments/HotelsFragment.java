package com.bonya.tourguide.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bonya.tourguide.R;
import com.bonya.tourguide.adapters.HotelAdapter;
import com.bonya.tourguide.models.Establishment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {
    ArrayList<Establishment> mHotels = new ArrayList<>();
    RecyclerView hotelsRecyclerView;

    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_hotels, container, false);

        hotelsRecyclerView = rootView.findViewById(R.id.hotels_rec_view);

        mHotels.add(new Establishment("Mawa Hotel", "Mile 6 Nkwen",2, 4, R.drawable.mawa_hotel));
        mHotels.add(new Establishment("Azam Hotel", "Mankon",3, 5, R.drawable.azam_hotel));
        mHotels.add(new Establishment("Blue Pearl Hotel", "Mile 3 Nkwen",3, 7, R.drawable.blue_pear_hotel));
        mHotels.add(new Establishment("Kangle Plaza Hotel", "Foncha Street",2, 5, R.drawable.kangle_plaza_hotel));
        mHotels.add(new Establishment("Top Star Hotel", "Ghana Street",2, 3, R.drawable.top_star_hotel));
        mHotels.add(new Establishment("Ayaba Hotel", "Old Town",3, 8, R.drawable.ayaba_hotel));
        mHotels.add(new Establishment("Saddle Hill Ranch", "Bafut",3, 8, R.drawable.saddle_hill_ranch));

        HotelAdapter myHotelAdapter = new HotelAdapter(mHotels, new HotelAdapter.OnItemClickedListener() {
            @Override
            public void onItemClicked(Establishment hotel) {
                Toast.makeText(getContext(), "item clicked", Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        hotelsRecyclerView.setLayoutManager(manager);
        hotelsRecyclerView.setAdapter(myHotelAdapter);
        hotelsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        return rootView;
    }

}
