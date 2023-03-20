package com.marko.photosapp.dto;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Viewability {
    NO_PAGES, PARTIAL;

    @JsonValue
    public String toValue() {
        switch (this) {
            case NO_PAGES: return "NO_PAGES";
            case PARTIAL: return "PARTIAL";
        }
        return null;
    }

    @JsonCreator
    public static Viewability forValue(String value) throws IOException {
        if (value.equals("NO_PAGES")) return NO_PAGES;
        if (value.equals("PARTIAL")) return PARTIAL;
        throw new IOException("Cannot deserialize Viewability");
    }
}
