package com.steven.authenticationservices.utils;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;

import java.text.ParseException;
import java.util.Date;

public class JWTUtils {
    public static Date getExpirationTime(String token) throws ParseException {
        JWT jwt = JWTParser.parse(token);
        JWTClaimsSet claimsSet = jwt.getJWTClaimsSet();
        return claimsSet.getIssueTime();
    }
}
