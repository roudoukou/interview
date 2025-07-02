package icu.xiamu.config;

import icu.xiamu.aop.LogAspects;
import icu.xiamu.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author roudoukou
 * @date 2025/6/22
 */
@Configuration
@EnableAspectJAutoProxy
public class MyConfigOfAOP {

    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }

}
