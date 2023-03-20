package com.marko.photosapp.dto;

import com.fasterxml.jackson.annotation.*;

public class SaleInfo {
    private Country country;
    private Saleability saleability;
    private boolean isEbook;

    @JsonProperty("country")
    public Country getCountry() { return country; }
    @JsonProperty("country")
    public void setCountry(Country value) { this.country = value; }

    @JsonProperty("saleability")
    public Saleability getSaleability() { return saleability; }
    @JsonProperty("saleability")
    public void setSaleability(Saleability value) { this.saleability = value; }

    @JsonProperty("isEbook")
    public boolean getIsEbook() { return isEbook; }
    @JsonProperty("isEbook")
    public void setIsEbook(boolean value) { this.isEbook = value; }
}
