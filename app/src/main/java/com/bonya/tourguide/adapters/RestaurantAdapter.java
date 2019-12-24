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

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {
    private final ArrayList<Establishment> mRestaurants;
    private final OnItemClickedListener listener;
    private Context mContext;

    public RestaurantAdapter(ArrayList<Establishment> restaurants, OnItemClickedListener listener) {
        mRestaurants = restaurants;
        this.listener = listener;
    }

    //An interface with one method to handle click events on the RecyclerView items
    public interface OnItemClickedListener{
         void onItemClicked(Establishment hotel);
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.restaurant_list_item, parent, false);
        return new RestaurantViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
    holder.bind(mRestaurants.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder{
        TextView resNameTextView;
        TextView descriptionTextView;
        ImageView resImageView;
        RatingBar resRatingBar;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            resNameTextView = itemView.findViewById(R.id.restaurant_name);
            descriptionTextView = itemView.findViewById(R.id.restaurant_info);
            resRatingBar = itemView.findViewById(R.id.restaurant_reviews);
            resImageView = itemView.findViewById(R.id.restaurant_image);
        }

        public void bind (final Establishment restaurant, final OnItemClickedListener listener){
            resNameTextView.setText(restaurant.getName());
            descriptionTextView.setText(restaurant.getDescription());
            resRatingBar.setProgress(restaurant.getReviews());
            Glide.with(mContext)
                    .load(restaurant.getImageResourceId())
                    .centerCrop()
                    .into(resImageView);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    listener.onItemClicked(restaurant);
                }
            });
        }
    }

}
