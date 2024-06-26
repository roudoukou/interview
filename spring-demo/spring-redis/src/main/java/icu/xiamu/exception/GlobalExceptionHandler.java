package icu.xiamu.exception;

import icu.xiamu.limit.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 特定异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody // 为了返回数据
    public R error(ArithmeticException e) {
        log.error(e.getMessage());
        return R.error("执行了ArithmeticException异常处理..");
    }

    // 自定义异常
    @ExceptionHandler(GuliException.class)
    @ResponseBody // 为了返回数据
    public R error(GuliException e) {
        log.error(e.getMessage());

        return R.error(e.getCode(), e.getMsg());
    }

    // 自定义异常
    @ExceptionHandler(RedisLimiterException.class)
    @ResponseBody // 为了返回数据
    public R error(RedisLimiterException e) {
        log.error(e.getMessage());

        return R.error(e.getCode(), e.getMessage());
    }

    // 指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody // 为了返回数据
    public R error(Exception e) {
        log.error(e.getMessage());
        return R.error("执行了全局异常处理..");
    }

}