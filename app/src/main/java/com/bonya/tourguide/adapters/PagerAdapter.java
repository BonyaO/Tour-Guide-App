package com.bonya.tourguide.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bonya.tourguide.fragments.HistoricalSitesFragment;
import com.bonya.tourguide.fragments.HotelsFragment;
import com.bonya.tourguide.fragments.EventsFragment;
import com.bonya.tourguide.fragments.RestaurantsFragment;

/**
 * A custom pager adapter to enable smooth swiping of tabs and fragments
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumberOfTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int numberOfTabs) {
        super(fm, numberOfTabs);
        this.mNumberOfTabs = numberOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new HotelsFragment();
            case 1: return new RestaurantsFragment();
            case 2: return new HistoricalSitesFragment();
            case 3: return new EventsFragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }
}
