package icu.xiamu.aop;

import org.springframework.stereotype.Component;

/**
 * @author roudoukou
 * @date 2025/6/22
 */
public class MathCalculator {
    public int div(int a, int b) {
        System.out.println("MathCalculator div");
        return a / b;
    }
}
