package com.marko.photosapp.dto;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Language {
    EN;

    @JsonValue
    public String toValue() {
        switch (this) {
            case EN: return "en";
        }
        return null;
    }

    @JsonCreator
    public static Language forValue(String value) throws IOException {
        if (value.equals("en")) return EN;
        throw new IOException("Cannot deserialize Language");
    }
}
