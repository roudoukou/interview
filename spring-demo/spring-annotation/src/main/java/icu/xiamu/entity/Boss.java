package icu.xiamu.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author roudoukou
 * @date 2025/6/21
 */
@Component
public class Boss {

    // @Autowired
    private Car car;

    public Car getCar() {
        return car;
    }

    @Autowired
    public Boss(@Autowired Car car) {
        this.car = car;
    }

    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
