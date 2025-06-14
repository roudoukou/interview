package icu.xiamu;

import icu.xiamu.config.MyConfig;
import icu.xiamu.config.MyConfig2;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author roudoukou
 * @date 2025/6/13
 */
public class ConfigTest {

    @Test
    void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    /**
     * 比较是否同一个对象
     */
    @Test
    void test02() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class);
        Object person1 = context.getBean("person");
        Object person2 = context.getBean("person");
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person1 == person2);
    }

    /**
     * prototype：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。
     * 					每次获取的时候才会调用方法创建对象；
     * singleton：单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。
     * 			以后每次获取就是直接从容器（map.get()）中拿，
     * request：同一次请求创建一个实例
     * session：同一个session创建一个实例
     *
     * 懒加载：
     * 		单实例bean：默认在容器启动的时候创建对象；
     * 		懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化；
     */
    @Test
    void test03() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class);
        context.getBean("person");

    }

}
