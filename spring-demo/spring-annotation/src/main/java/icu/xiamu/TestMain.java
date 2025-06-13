package icu.xiamu;

import icu.xiamu.config.MyConfig;
import icu.xiamu.entity.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.UnsupportedEncodingException;

/**
 * @author roudoukou
 * @date 2025/6/13
 */
public class TestMain {
    public static void main(String[] args) {
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // Person person = (Person) context.getBean("person");
        // System.out.println(person);

        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println(context1);
        Person bean = context1.getBean(Person.class);
        System.out.println(bean);

        Object peiqi = context1.getBean("peiqi");
        System.out.println("peiqi = " + peiqi);

        String[] beanDefinitionNames = context1.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
