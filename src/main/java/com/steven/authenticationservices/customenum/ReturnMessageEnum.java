package com.steven.authenticationservices.customenum;

import lombok.Getter;

@Getter
public enum ReturnMessageEnum {
    LOGIN_SUCCESS_MESSAGE("Login Success"),
    LOGIN_FAILED_MESSAGE("Login Failed : wrong credentials"),
    QUERY_DATA_SUCCESS_MESSAGE("Query Success, Data returned.");
    // Getter method to retrieve the string value
    // String value associated with each enum constant
    private final String stringValue;

    // Constructor to initialize the string value
    ReturnMessageEnum(String stringValue) {
        this.stringValue = stringValue;
    }

}
