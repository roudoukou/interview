package icu.xiamu.controller;

import icu.xiamu.limit.R;
import icu.xiamu.limit.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Random;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/30
 */
@Slf4j
@RestController
public class HelloController {
    @RateLimiter(count = 3, time = 3)
    @GetMapping("/hello")
    public R<String> hello(String value) {
        LocalDateTime now = LocalDateTime.now();
        return R.ok("hello, now time is " + now, value);
    }
}
