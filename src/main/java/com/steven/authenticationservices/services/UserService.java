package com.steven.authenticationservices.services;

import com.steven.authenticationservices.models.ApplicationUser;
import com.steven.authenticationservices.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the user details servies.....");
        if(!username.equals("Ethan")) throw new UsernameNotFoundException("Not Ethan.");

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1,"USER"));
        return new ApplicationUser(1,"Ethan",encoder.encode("password"),roles);
    }
}