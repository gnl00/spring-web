package com.demo.controller;

import com.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author gnl
 * @since 2023/4/21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/get")
    @JsonView(User.WithoutPasswordView.class)
    public User getUser() {
        return new User("eric", "7!jd#h23");
    }
}