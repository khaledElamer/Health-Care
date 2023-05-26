package Healthy.Healthy.app.enums;

import Healthy.Healthy.app.exception.IllegalAttributeException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum InsuranceProvider {
    COMPANY_A("COMPANY_A"),
    COMPANY_B("COMPANY_B"),
    COMPANY_C("COMPANY_C"),
    COMPANY_D("COMPANY_D");

    private String value;

    InsuranceProvider(String value)
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
    public static InsuranceProvider forValue(String value)
    {
        if (value.isEmpty())
            return null;
        try {
            return InsuranceProvider.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalAttributeException("The allowed values of InsuranceProvider " +
                    Arrays.toString(InsuranceProvider.values()));
        }
    }
}
