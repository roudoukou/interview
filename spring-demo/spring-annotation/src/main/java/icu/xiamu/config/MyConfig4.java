package icu.xiamu.config;

import icu.xiamu.entity.Red;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author roudoukou
 * @date 2025/6/21
 */
@Component
public class MyConfig4 {
    @Bean
    public Red red() {
        return new Red();
    }
}
