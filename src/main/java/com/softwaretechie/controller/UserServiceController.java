package com.softwaretechie.controller;

import com.softwaretechie.model.Item;
import com.softwaretechie.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserServiceController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/items")
    public List<Item> fetchCatalogItems(){
        return userService.fetchCatalogDetails();
    }
}
