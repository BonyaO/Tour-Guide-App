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
import com.bonya.tourguide.models.Event;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * A Custom Adapter to efficiently display a liist of events in a RecyclerView
 *
 * */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private final ArrayList<Event> mEvents;
    private final OnItemClickedListener listener;
    private Context mContext;

    //An interface with one method to handle click events on the RecyclerView items
    public interface OnItemClickedListener{
        void onItemClicked(Event event);
    }

    public EventAdapter(ArrayList<Event> events, OnItemClickedListener listener) {
        mEvents = events;
        this.listener = listener;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.event_list_item, parent, false);
        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.bind(mEvents.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }
    //Custom viewHolder
    public class EventViewHolder extends RecyclerView.ViewHolder{
        TextView eventHeadingTV;
        TextView eventDescriptionTV;
        TextView venueTV;
        TextView dateTV;
        ImageView eventImageView;
        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            eventHeadingTV = itemView.findViewById(R.id.event_name);
            eventDescriptionTV = itemView.findViewById(R.id.event_description);
            eventImageView = itemView.findViewById(R.id.event_image);
            venueTV = itemView.findViewById(R.id.venue);
            dateTV = itemView.findViewById(R.id.date);
        }
        public void bind(final Event event, final OnItemClickedListener listener){
            eventHeadingTV.setText(event.getEventName());
            eventDescriptionTV.setText(event.getEventDescription());
            dateTV.setText(event.getEventDate());
            venueTV.setText(event.getEventVenue());
            Glide.with(mContext)
                    .load(event.getImageResourceId())
                    .centerCrop()
                    .into(eventImageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClicked(event);
                }
            });
        }

    }
}
