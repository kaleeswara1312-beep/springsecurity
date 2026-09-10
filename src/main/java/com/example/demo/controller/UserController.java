package com.example.demo.controller;

import com.example.demo.model.Users;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UsersService usersService;

    @PostMapping("/admin/register")
    public String register(@RequestBody Users user){
        return usersService.register(user);
    }

    @PostMapping("/dlogin")
    public String login(@RequestBody Users user){
//        return usersService.verify(user);
        return "Login";
    }
}
