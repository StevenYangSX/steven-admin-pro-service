package com.steven.authenticationservices.controllers;

import com.steven.authenticationservices.customenum.ReturnMessageEnum;
import com.steven.authenticationservices.customenum.SuccessFailedEnum;
import com.steven.authenticationservices.dto.ResponseDTO;
import com.steven.authenticationservices.models.Menu;
import com.steven.authenticationservices.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("systemMenu")
@CrossOrigin(origins = "*")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "menuList")
    public ResponseDTO<List> systemMenuList() {
        List<Menu> syestemMenuList = menuService.getSyestemMenuList();
        return new ResponseDTO<>(HttpStatus.OK.value(), SuccessFailedEnum.SUCCESS.getStringValue(),
                ReturnMessageEnum.QUERY_DATA_SUCCESS_MESSAGE.getStringValue(),syestemMenuList);

    }
}
