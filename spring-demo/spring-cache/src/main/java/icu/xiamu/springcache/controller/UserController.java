package icu.xiamu.springcache.controller;

import icu.xiamu.springcache.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/{name}")
    public String hello(@PathVariable String name) {
        return userService.getUserName(name);
    }
}
