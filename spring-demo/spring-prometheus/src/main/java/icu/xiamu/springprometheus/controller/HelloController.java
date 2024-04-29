package icu.xiamu.springprometheus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/29
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello1() {
        return "hello";
    }

    @RequestMapping("/hello")
    public String hello2() {
        return "hello";
    }
}
