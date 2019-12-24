package com.bonya.tourguide.models;

public class Establishment {
    private String mName;
    private String mDescription;
    private int mRating;
    private int mReviews;

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    private int imageResourceId;

    public Establishment(String name, String description, int rating, int mReviews, int imageResource) {
        this.mName = name;
        this.mDescription = description;
        this.mRating = rating;
        this.mReviews = mReviews;
        this.imageResourceId = imageResource;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public int getRating() {
        return mRating;
    }

    public void setRating(int rating) {
        mRating = rating;
    }

    public int getReviews() {
        return mReviews;
    }

    public void setReviews(int reviews) {
        this.mReviews = reviews;
    }
}
