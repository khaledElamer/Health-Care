package Healthy.Healthy.app.enums;

import Healthy.Healthy.app.exception.IllegalAttributeException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * @author : Omar_Hany
 * @since : Monday , 1/23/2023
 */
public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE");

    private String value;

    Gender(String value)
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
    public static Gender forValue(String value)
    {
        if (value.isEmpty())
            return null;
        try {
            return Gender.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalAttributeException("The allowed values of Gender " +
                    Arrays.toString(Gender.values()));
        }
    }


}
