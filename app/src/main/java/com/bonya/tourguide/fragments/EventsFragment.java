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
import com.bonya.tourguide.adapters.EventAdapter;
import com.bonya.tourguide.models.Event;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {
    private ArrayList<Event> mEvents = new ArrayList<>();
    RecyclerView eventsRecyclerView;

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_events, container, false);

        eventsRecyclerView = rootView.findViewById(R.id.events_rec_view);

        mEvents.add(new Event("Babanki Cultural Week", "27/12/2019", "The people of Babanki showcase their culture", "Kijem Keku", R.drawable.babanki));
        mEvents.add(new Event("Enthronement of Fon of Kom", "04/01/2020", "Following the passing of his father, HRH Bia James take the throne", "Kom", R.drawable.kom));

        EventAdapter adapter = new EventAdapter(mEvents, new EventAdapter.OnItemClickedListener() {
            @Override
            public void onItemClicked(Event event) {
                Toast.makeText(getContext(), "Item Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        eventsRecyclerView.setAdapter(adapter);
        eventsRecyclerView.setLayoutManager(manager);
        eventsRecyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }

}
