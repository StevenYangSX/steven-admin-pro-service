package com.steven.authenticationservices.services;

import com.steven.authenticationservices.models.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {
    public List<Menu> getSyestemMenuList ();
}
