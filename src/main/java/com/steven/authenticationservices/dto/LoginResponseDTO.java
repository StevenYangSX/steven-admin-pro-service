package com.steven.authenticationservices.dto;

import com.steven.authenticationservices.models.ApplicationUser;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LoginResponseDTO {

    private ApplicationUser user;
    private String token;
    private Long expiredTime;
    private List<String> menus;
    private List<String> uniqueAuth;

}
