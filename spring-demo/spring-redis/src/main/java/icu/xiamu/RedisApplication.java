package icu.xiamu;

import icu.xiamu.limit.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/30
 */
@SpringBootApplication
public class RedisApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RedisApplication.class, args);
        SpringUtils.set(context);
    }
}
