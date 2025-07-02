package icu.xiamu.entity;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author roudoukou
 * @date 2025/6/21
 */
@Component
public class Dog implements ApplicationContextAware {

    ApplicationContext context;

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


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
