package com.marko.photosapp.dto;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Type {
    ISBN_10, ISBN_13;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ISBN_10: return "ISBN_10";
            case ISBN_13: return "ISBN_13";
        }
        return null;
    }

    @JsonCreator
    public static Type forValue(String value) throws IOException {
        if (value.equals("ISBN_10")) return ISBN_10;
        if (value.equals("ISBN_13")) return ISBN_13;
        throw new IOException("Cannot deserialize Type");
    }
}
