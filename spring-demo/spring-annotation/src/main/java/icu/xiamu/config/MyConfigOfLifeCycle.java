package icu.xiamu.config;

import icu.xiamu.entity.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author roudoukou
 * @date 2025/6/21
 */
@Configuration
public class MyConfigOfLifeCycle {

    // @Scope("singleton")
    // @Scope("prototype")
    @Bean(initMethod = "init" , destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
