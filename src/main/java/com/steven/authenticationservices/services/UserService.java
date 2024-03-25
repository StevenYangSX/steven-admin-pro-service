package com.steven.authenticationservices.services;

import com.steven.authenticationservices.models.ApplicationUser;
import com.steven.authenticationservices.models.Role;
import com.steven.authenticationservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 多表联查
        // 1. 查询用户的角色信息
        // 2. 查询用户的权限信息
        Optional<ApplicationUser> userDetails = userRepository.findByUsername(username);

        if (userDetails.isPresent()) {
            // TODO 查看权限 角色 等信息.....
//            Collection<? extends GrantedAuthority> authorities = userDetails.get().getAuthorities();
//            for(GrantedAuthority authority : authorities) {
//                String authority1 = authority.getAuthority();
//                System.out.println("dddddd"+authority1);
//
//            }
            return userDetails.get();
        }
        throw new UsernameNotFoundException("User not found...........");

    }
}
