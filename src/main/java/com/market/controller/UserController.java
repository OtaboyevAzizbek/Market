package com.market.controller;

import com.market.dto.user.CreateUserDTO;
import com.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create_user")
    public void signup(@RequestBody CreateUserDTO createUserDTO) {
        userService.createUser(createUserDTO);
    }
}
