package com.marko.photosapp.dto;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum AccessViewStatus {
    NONE, SAMPLE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case NONE: return "NONE";
            case SAMPLE: return "SAMPLE";
        }
        return null;
    }

    @JsonCreator
    public static AccessViewStatus forValue(String value) throws IOException {
        if (value.equals("NONE")) return NONE;
        if (value.equals("SAMPLE")) return SAMPLE;
        throw new IOException("Cannot deserialize AccessViewStatus");
    }
}
