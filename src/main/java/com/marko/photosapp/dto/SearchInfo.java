package com.marko.photosapp.dto;

import com.fasterxml.jackson.annotation.*;

public class SearchInfo {
    private String textSnippet;

    @JsonProperty("textSnippet")
    public String getTextSnippet() { return textSnippet; }
    @JsonProperty("textSnippet")
    public void setTextSnippet(String value) { this.textSnippet = value; }
}
