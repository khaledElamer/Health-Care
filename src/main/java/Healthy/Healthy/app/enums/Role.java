package Healthy.Healthy.app.enums;

import Healthy.Healthy.app.exception.IllegalAttributeException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Role {
    UNKNOWN("UNKNOWN"),
     IN_SERVICE("IN_SERVICE"),
     OUT_OF_SERVICE("OUT_OF_SERVICE"),
    TESTING("TESTING"),
     IN_MAINTENANCE("IN_MAINTENANCE"),
     NOT_AVAILABLE ("NOT_AVAILABLE"),
     NOT_APPLICABLE("NOT_APPLICABLE");

    private String value;

    Role(String value)
    {
        this.value = value;
    }

    @JsonValue
    public String getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return String.valueOf(value);
    }

    @JsonCreator
    public static Role forValue(String value)
    {
        if (value.isEmpty())
            return null;
        try {
            return Role.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalAttributeException("The allowed values of Role " +
                    Arrays.toString(Role.values()));
        }
    }


}
