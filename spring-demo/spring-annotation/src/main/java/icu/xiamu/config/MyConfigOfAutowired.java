package icu.xiamu.config;

import icu.xiamu.entity.Car;
import icu.xiamu.entity.Color;
import icu.xiamu.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

/**
 * @author roudoukou
 * @date 2025/6/21
 * Autowired相关的测试配置类
 */
@ComponentScans({
        @ComponentScan("icu.xiamu.controller"),
        @ComponentScan("icu.xiamu.service"),
        @ComponentScan("icu.xiamu.repository"),
        @ComponentScan("icu.xiamu.config")
})
@Configuration
public class MyConfigOfAutowired {

    @Primary
    @Bean
    public BookRepository bookRepository2() {
        BookRepository bookRepository = new BookRepository();
        bookRepository.setLabel(2);
        return bookRepository;
    }

    @Bean
    public Color color(/*@Autowired*/ /*可加可不加*/ Car car) {
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
