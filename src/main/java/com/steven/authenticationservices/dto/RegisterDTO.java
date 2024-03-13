package com.steven.authenticationservices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class RegisterDTO {
    private String username;
    private String password;
}
