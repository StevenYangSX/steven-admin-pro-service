package com.steven.authenticationservices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.net.http.HttpResponse;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {
    private HttpStatus statusCode;
    private String message;
    private T data;
}
