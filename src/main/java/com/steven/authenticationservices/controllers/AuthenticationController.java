package com.steven.authenticationservices.controllers;

import com.steven.authenticationservices.dto.LoginResponseDTO;
import com.steven.authenticationservices.dto.RegisterDTO;
import com.steven.authenticationservices.models.ApplicationUser;
import com.steven.authenticationservices.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegisterDTO registerDTO) {
        return authenticationService.registerUser(registerDTO.getUsername(), registerDTO.getPassword());
    }

    @PostMapping("/login")
    private LoginResponseDTO loginUser(@RequestBody RegisterDTO loginDTO) {
        return authenticationService.loginUser(loginDTO.getUsername(), loginDTO.getPassword());
    }
}
