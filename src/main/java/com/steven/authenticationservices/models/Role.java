package com.steven.authenticationservices.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;


@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer roleId;

    private String authority;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_menu_junction",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "menu_id")}
    )
    private Set<Menu> menus;

    public Role(String role) {
        this.authority = role;
    }


    @Override
    public String getAuthority() {
        return this.authority;
    }

}
