package com.steven.authenticationservices.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE menu SET deleted = true WHERE menu_id=?")
@Where(clause = "deleted=0")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    private Integer menuId;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer parentId=0;

    @Column(unique = true)
    private String menuName;

    @Column(unique = true)
    private String path;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer sort=0;

    private String uniqAuth;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer menuType=0;

    private String icon;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer deleted=0;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
