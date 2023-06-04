package com.lkhadirn.guava_cache_implementation.controllers;

import com.lkhadirn.guava_cache_implementation.core.UserRetriever;
import com.lkhadirn.guava_cache_implementation.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MainController {

    @Autowired
    private UserRetriever userRetriever;

    @GetMapping(value = "/users", produces = "application/json")
    public List<User> getAllUsers() {
        return userRetriever.getAllUsers();
    }
}
