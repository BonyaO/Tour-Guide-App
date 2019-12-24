package com.bonya.tourguide.models;

public class Event {
    private String eventName;
    private String eventDate;
    private String eventDescription;
    private String eventVenue;
    private int imageResourceId;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public Event(String eventName, String eventDate, String eventDescription, String eventVenue, int imageResourceId) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.eventVenue = eventVenue;
        this.imageResourceId = imageResourceId;
    }
}
