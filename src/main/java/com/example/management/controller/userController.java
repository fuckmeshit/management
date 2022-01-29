package com.example.management.controller;

import com.example.management.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import com.example.management.service.userService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class userController {
    @Autowired
    private userService userservice;
    @CrossOrigin
    @GetMapping("/user/{page}/{size}")
    public List<User> list(
            @PathVariable("page") Integer page,
            @PathVariable("size") Integer size
    ){
       return userservice.userList(page,size);
    }
}
