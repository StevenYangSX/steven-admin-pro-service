package com.steven.authenticationservices.dto;

import com.steven.authenticationservices.models.ApplicationUser;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {

    private ApplicationUser user;
    private String jwt;

}
