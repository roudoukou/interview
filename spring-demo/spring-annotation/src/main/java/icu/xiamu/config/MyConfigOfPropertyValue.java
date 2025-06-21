package icu.xiamu.config;

/**
 * @author roudoukou
 * @date 2025/6/21
 */

import icu.xiamu.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * 属性赋值
 */
// @PropertySource("classpath:person.properties")
@PropertySources({@PropertySource("classpath:person.properties")})
@Configuration
public class MyConfigOfPropertyValue {
    @Bean
    public Person person() {
        return new Person();
    }
}
