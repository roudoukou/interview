package icu.xiamu.entity;

import org.springframework.stereotype.Component;

/**
 * @author roudoukou
 * @date 2025/6/15
 */
public class Color {
    private Car car;

    public Color() {
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }
}
