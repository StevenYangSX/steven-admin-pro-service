package com.steven.authenticationservices.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.steven.authenticationservices.customenum.ReturnMessageEnum;
import com.steven.authenticationservices.customenum.SuccessFailedEnum;
import com.steven.authenticationservices.dto.ResponseDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(200); // Set status code to 200
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(
                new ResponseDTO<>(40000, SuccessFailedEnum.SUCCESS.getStringValue(),
                        ReturnMessageEnum.LOGIN_FAILED_MESSAGE.getStringValue(), null)));
    }
}
