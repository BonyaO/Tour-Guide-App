package com.bonya.tourguide.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bonya.tourguide.R;
import com.bonya.tourguide.models.HistoricalSite;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HistoricalSiteAdapter extends RecyclerView.Adapter<HistoricalSiteAdapter.HistoricalSiteViewHolder> {
    private final ArrayList<HistoricalSite> mSites;
    private final OnItemClickedListener listener;
    private Context mContext;

    public HistoricalSiteAdapter(ArrayList<HistoricalSite> sites, OnItemClickedListener listener) {
        this.mSites = sites;
        this.listener = listener;
    }

    //An interface with one method to handle click events on the RecyclerView items
    public interface OnItemClickedListener{
        void onItemClicked(HistoricalSite site);
    }
    @NonNull
    @Override
    public HistoricalSiteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.historical_site_list_item, parent, false);
        return new HistoricalSiteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricalSiteViewHolder holder, int position) {
        holder.bind(mSites.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return mSites.size();
    }
    public class HistoricalSiteViewHolder extends RecyclerView.ViewHolder {
        ImageView siteImage;
        TextView siteNameTextView;
        TextView siteDetailsTextView;
        public HistoricalSiteViewHolder(@NonNull View itemView) {
            super(itemView);
            siteImage = itemView.findViewById(R.id.historical_site_image);
            siteNameTextView = itemView.findViewById(R.id.site_name);
            siteDetailsTextView = itemView.findViewById(R.id.site_description);
        }
        public void bind(final HistoricalSite site, final OnItemClickedListener listener){
            siteNameTextView.setText(site.getSiteName());
            siteDetailsTextView.setText(site.getSiteDetails());
            Glide.with(mContext)
                    .load(site.getImageResourceId())
                    .centerCrop()
                    .into(siteImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClicked(site);
                }
            });
        }
    }
}
