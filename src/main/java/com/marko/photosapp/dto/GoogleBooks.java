package com.marko.photosapp.dto;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class GoogleBooks {
    private String kind;
    private long totalItems;
    private List<Item> items;

    @JsonProperty("kind")
    public String getKind() { return kind; }
    @JsonProperty("kind")
    public void setKind(String value) { this.kind = value; }

    @JsonProperty("totalItems")
    public long getTotalItems() { return totalItems; }
    @JsonProperty("totalItems")
    public void setTotalItems(long value) { this.totalItems = value; }

    @JsonProperty("items")
    public List<Item> getItems() { return items; }
    @JsonProperty("items")
    public void setItems(List<Item> value) { this.items = value; }
}
