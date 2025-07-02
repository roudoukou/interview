package icu.xiamu;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author roudoukou
 * @date 2025/6/13
 */
public class XmlTest {

    @Test
    void test01() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        int beanDefinitionCount = context.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

}
