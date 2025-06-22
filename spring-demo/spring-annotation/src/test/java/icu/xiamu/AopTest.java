package icu.xiamu;

import icu.xiamu.aop.MathCalculator;
import icu.xiamu.config.MyConfigOfAOP;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author roudoukou
 * @date 2025/6/22
 */
public class AopTest {

    /**
     * 正常运行
     */
    @Test
    void test01() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfigOfAOP.class);
        MathCalculator bean = context.getBean(MathCalculator.class);
        int div = bean.div(1, 1);
        System.out.println(div);
    }

    /**
     * 异常运行
     */
    @Test
    void test02() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfigOfAOP.class);
        MathCalculator bean = context.getBean(MathCalculator.class);
        int div = bean.div(1, 0);
    }
}
