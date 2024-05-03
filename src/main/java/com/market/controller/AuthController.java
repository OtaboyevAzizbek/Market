package com.market.controller;

import com.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    UserService userService;

    @GetMapping
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

    @PostMapping
    public void signIn(@RequestParam("username") String username, @RequestParam("password") String password) {
        userService.signIn(username, password);
    }
}
