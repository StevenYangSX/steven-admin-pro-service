package com.steven.authenticationservices.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    private Integer menuId;

    private Integer parentId;

    @Column(unique = true)
    private String menuName;

    private Integer sort;

    private String perms;

    private Integer menuType;

    private String icon;

    private Integer deleted;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
