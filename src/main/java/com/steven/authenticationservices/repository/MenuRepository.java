package com.steven.authenticationservices.repository;

import com.steven.authenticationservices.models.Menu;
import com.steven.authenticationservices.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    Optional<Menu> findByMenuName(String menuName);
}
