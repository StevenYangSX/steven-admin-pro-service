package com.steven.authenticationservices.services;

import com.steven.authenticationservices.customenum.ReturnMessageEnum;
import com.steven.authenticationservices.customenum.SuccessFailedEnum;
import com.steven.authenticationservices.dto.LoginResponseDTO;
import com.steven.authenticationservices.dto.ResponseDTO;
import com.steven.authenticationservices.models.ApplicationUser;
import com.steven.authenticationservices.models.Role;
import com.steven.authenticationservices.repository.RoleRepository;
import com.steven.authenticationservices.repository.UserRepository;
import com.steven.authenticationservices.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;


    public ApplicationUser registerUser(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();
        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);
        return userRepository.save(new ApplicationUser(0, username, encodedPassword, authorities));
    }

    public ResponseDTO<LoginResponseDTO> loginUser(String username, String password) throws ParseException {

        Authentication auth = null;
        try {
            auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            String token = tokenService.generateJwt(auth);
            List<String> tempMenuList = new ArrayList<>();
            List<String> tempAuthList = new ArrayList<>();
            LoginResponseDTO loginResponseDTO = new LoginResponseDTO(
                    userRepository.findByUsername(username).get(),
                    token,
                    JWTUtils.getExpirationTime(token).getTime(),
                    tempMenuList,
                    tempAuthList);

            return new ResponseDTO<>(HttpStatus.OK.value(),
                    SuccessFailedEnum.SUCCESS.getStringValue(),
                    ReturnMessageEnum.LOGIN_SUCCESS_MESSAGE.getStringValue(),
                    loginResponseDTO);
        } catch (AuthenticationException e) {
            return new ResponseDTO<>(200, "Success", e.getMessage(), null);
        }
    }
}
