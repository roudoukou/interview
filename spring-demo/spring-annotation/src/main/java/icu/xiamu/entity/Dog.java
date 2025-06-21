package icu.xiamu.entity;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author roudoukou
 * @date 2025/6/21
 */
@Component
public class Dog {
    public Dog() {
        System.out.println("Dog constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("Dog PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Dog PreDestroy");
    }



}
