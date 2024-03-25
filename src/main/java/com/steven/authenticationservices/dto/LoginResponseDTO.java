package com.steven.authenticationservices.dto;

import com.steven.authenticationservices.models.ApplicationUser;
import com.steven.authenticationservices.models.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class LoginResponseDTO {

    private ApplicationUser user;
    private String token;
    private Long expiredTime;
    private Set<Menu> menus;
    private Set<String> uniqueAuth;

}
