package com.bonya.tourguide.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bonya.tourguide.R;
import com.bonya.tourguide.models.Establishment;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {
    private final ArrayList<Establishment> mHotels;
    private final OnItemClickedListener listener;
    private Context mContext;

    public HotelAdapter(ArrayList<Establishment> hotels, OnItemClickedListener listener) {
        mHotels = hotels;
        this.listener = listener;
    }

    //An interface with one method to handle click events on the RecyclerView items
    public interface OnItemClickedListener{
         void onItemClicked(Establishment hotel);
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.hotel_list_item, parent, false);
        return new HotelViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {
    holder.bind(mHotels.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return mHotels.size();
    }

    public class HotelViewHolder extends RecyclerView.ViewHolder{
        TextView hotelNameTextView;
        TextView hotelRatingTextView;
        ImageView hotelImageView;
        RatingBar hotelRatingBar;

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);
            hotelNameTextView = itemView.findViewById(R.id.hotel_name);
            hotelRatingTextView = itemView.findViewById(R.id.hotel_rating);
            hotelRatingBar = itemView.findViewById(R.id.hotel_reviews);
            hotelImageView = itemView.findViewById(R.id.hotel_image);
        }

        public void bind (final Establishment hotel, final OnItemClickedListener listener){
            hotelNameTextView.setText(hotel.getName());
            hotelRatingTextView.setText(String.valueOf(hotel.getRating()));
            hotelRatingBar.setProgress(hotel.getReviews());
            Glide.with(mContext)
                    .load(hotel.getImageResourceId())
                    .centerCrop()
                    .into(hotelImageView);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    listener.onItemClicked(hotel);
                }
            });
        }
    }

}
