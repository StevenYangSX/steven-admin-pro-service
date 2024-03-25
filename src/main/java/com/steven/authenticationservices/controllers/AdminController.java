package com.steven.authenticationservices.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public String helloAdminController() {
        // Get the authentication object from the security context
        Authentication authentication;
        try {
            authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.getAuthorities().stream()
                    .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"))) {
                return "User is authorized.";
            } else {
                return "User is NOT authorized.";
            }
        } catch (AuthenticationException e) {
            return e.getMessage();
        }

    }

}
