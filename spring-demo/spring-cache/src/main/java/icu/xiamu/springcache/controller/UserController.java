package icu.xiamu.springcache.controller;

import icu.xiamu.springcache.entity.User;
import icu.xiamu.springcache.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("getUserName/{name}")
    public String getUserName(@PathVariable String name) {
        return userService.getUserName(name);
    }

    @RequestMapping("/save")
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @RequestMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @RequestMapping("/remove/{id}")
    public void remove(@PathVariable Integer id) {
        userService.remove(id);
    }
}
