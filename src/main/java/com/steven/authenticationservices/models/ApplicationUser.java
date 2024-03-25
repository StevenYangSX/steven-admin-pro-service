package com.steven.authenticationservices.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    @NonNull
    private Integer userId;

    @Column(unique = true)
    @NonNull
    private String username;

    @NonNull
    @JsonIgnore
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role_junction",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    @NonNull
    private Set<Role> authorities;

    @Transient
    @JsonIgnore
    private Set<Menu> menus = new HashSet<>();

    public ApplicationUser(String admin, String password, Set<Role> roles) {
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

            HashSet<GrantedAuthority> result = new HashSet<>();

            for(Role role : authorities) {
                result.add(new SimpleGrantedAuthority(role.getAuthority()));
                this.menus.addAll(role.getMenus());
            }
            if(!result.isEmpty()) {
               return result;
            }
        return null;
    }

    @Override

    public @NonNull String getPassword() {
        return this.password;
    }

    @Override
    public @NonNull String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
