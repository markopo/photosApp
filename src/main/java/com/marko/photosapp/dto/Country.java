package com.marko.photosapp.dto;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Country {
    SE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case SE: return "SE";
        }
        return null;
    }

    @JsonCreator
    public static Country forValue(String value) throws IOException {
        if (value.equals("SE")) return SE;
        throw new IOException("Cannot deserialize Country");
    }
}