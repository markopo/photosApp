package com.marko.photosapp;

import jakarta.validation.constraints.NotEmpty;

public class Photo {
    private String id;

    @NotEmpty(message = "Filename is required!")
    private String fileName;

    public Photo() {

    }

    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
