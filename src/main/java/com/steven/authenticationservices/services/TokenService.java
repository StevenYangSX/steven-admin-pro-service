package com.steven.authenticationservices.services;

import com.steven.authenticationservices.models.ApplicationUser;
import com.steven.authenticationservices.models.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TokenService {

    @Autowired
    private JwtEncoder jwtEncoder;
    @Autowired
    private JwtDecoder jwtDecoder;

    public String generateJwt(Authentication authentication,    ApplicationUser currentUserInfo) {
        Instant now = Instant.now();
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        Set<String> uniqueAuth = currentUserInfo.getMenus().stream().map(Menu::getUniqAuth)
                .collect(Collectors.toSet());

        JwtClaimsSet claims = JwtClaimsSet.builder().issuer("self").issuedAt(now).subject(authentication.getName())
                .claim("roles",scope)
                .claim("uniqueAuth",uniqueAuth)
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
