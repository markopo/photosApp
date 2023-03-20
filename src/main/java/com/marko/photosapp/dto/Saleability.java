package com.marko.photosapp.dto;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Saleability {
    NOT_FOR_SALE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case NOT_FOR_SALE: return "NOT_FOR_SALE";
        }
        return null;
    }

    @JsonCreator
    public static Saleability forValue(String value) throws IOException {
        if (value.equals("NOT_FOR_SALE")) return NOT_FOR_SALE;
        throw new IOException("Cannot deserialize Saleability");
    }
}
