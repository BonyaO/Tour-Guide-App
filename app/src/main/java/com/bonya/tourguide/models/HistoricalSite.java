package com.bonya.tourguide.models;

public class HistoricalSite {
    private String siteName;
    private String siteDetails;
    private int imageResourceId;

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteDetails() {
        return siteDetails;
    }

    public void setSiteDetails(String siteDetails) {
        this.siteDetails = siteDetails;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public HistoricalSite(String siteName, String siteDetails, int imageResourceId) {
        this.siteName = siteName;
        this.siteDetails = siteDetails;
        this.imageResourceId = imageResourceId;
    }
}
