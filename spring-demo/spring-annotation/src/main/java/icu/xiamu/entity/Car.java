package icu.xiamu.entity;

import java.util.function.Function;

/**
 * @author roudoukou
 * @date 2025/6/21
 */
public class Car {
    public Car() {
        System.out.println("Car 方法创建");
    }

    public void init() {
        System.out.println("Car 方法初始化");
    }

    public void destroy() {
        System.out.println("Car 方法销毁");
    }
}
