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
import com.bonya.tourguide.adapters.HistoricalSiteAdapter;
import com.bonya.tourguide.models.HistoricalSite;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoricalSitesFragment extends Fragment {
    ArrayList<HistoricalSite> mSites = new ArrayList<>();
    RecyclerView sitesRecyclerView;

    public HistoricalSitesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_historical_sites, container, false);
        sitesRecyclerView = rootView.findViewById(R.id.sites_rec_view);

        mSites.add(new HistoricalSite(getString(R.string.lake_oku), getResources().getString(R.string.lake_oku_details),R.drawable.lake_oku));
        mSites.add(new HistoricalSite(getString(R.string.mankon_palace), getResources().getString(R.string.lake_oku_details),R.drawable.mankon));
        mSites.add(new HistoricalSite(getString(R.string.lake_oku), getResources().getString(R.string.lake_oku_details),R.drawable.lake_oku));
        mSites.add(new HistoricalSite(getString(R.string.lake_oku), getResources().getString(R.string.lake_oku_details),R.drawable.lake_oku));
        mSites.add(new HistoricalSite(getString(R.string.lake_oku), getResources().getString(R.string.lake_oku_details),R.drawable.lake_oku));
        mSites.add(new HistoricalSite(getString(R.string.lake_oku), getResources().getString(R.string.lake_oku_details),R.drawable.lake_oku));


        HistoricalSiteAdapter adapter = new HistoricalSiteAdapter(mSites, new HistoricalSiteAdapter.OnItemClickedListener() {
            @Override
            public void onItemClicked(HistoricalSite site) {
                Toast.makeText(getContext(), R.string.item_clicked, Toast.LENGTH_SHORT).show();

            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        sitesRecyclerView.setAdapter(adapter);
        sitesRecyclerView.setLayoutManager(manager);
        sitesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        return rootView;
    }

}
