package com.steven.authenticationservices.customenum;

import lombok.Getter;

@Getter
public enum SuccessFailedEnum {
    SUCCESS("SUCCESS"),
    FAILED("FAILED");

    // Getter method to retrieve the string value
    // String value associated with each enum constant
    private final String stringValue;

    // Constructor to initialize the string value
    SuccessFailedEnum(String stringValue) {
        this.stringValue = stringValue;
    }

}
