package com.steven.authenticationservices.controllers;

import com.steven.authenticationservices.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@CrossOrigin("*")
public class HealthCheckController {
    @GetMapping("/")
    public ResponseDTO healthCheck() {
       return new ResponseDTO<>(HttpStatus.OK.value(),"Success","Server is running...",null);
    }
}
