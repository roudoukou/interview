package icu.xiamu;

import icu.xiamu.config.MyConfig;
import icu.xiamu.config.MyConfig2;
import icu.xiamu.config.MyConfig3;
import icu.xiamu.config.MyConfigOfLifeCycle;
import icu.xiamu.entity.Person;
import icu.xiamu.entity.factory.ColorFactoryBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.Map;

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

    @Test
    void test04() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig3.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("===");
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        System.out.println("===");
        Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }

    @Test
    void test05() {
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("abc"));
    }

    /**
     * 给容器中注册组件；
     * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[自己写的类]
     * 2）、@Bean[导入的第三方包里面的组件]
     * 3）、@Import[快速给容器中导入一个组件]
     * 		1）、@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
     * 		2）、ImportSelector:返回需要导入的组件的全类名数组；
     * 		3）、ImportBeanDefinitionRegistrar:手动注册bean到容器中
     * 4）、使用Spring提供的 FactoryBean（工厂Bean）;
     * 		1）、默认获取到的是工厂bean调用getObject创建的对象
     * 		2）、要获取工厂Bean本身，我们需要给id前面加一个&
     * 			&colorFactoryBean
     */
    @Test
    void test06() {
        // Import注解测试
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig3.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    void test07() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig3.class);
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        // 获取 Color 对象
        Object bean = context.getBean("colorFactoryBean");
        System.out.println(bean);

        // 获取 FactoryBean 本身这个对象，不获取 Color 对象
        Object bean1 = context.getBean("&colorFactoryBean");
        System.out.println(bean1);
    }

    /**
     * Bean 生命周期测试
     * bean的生命周期：
     * 		bean创建---初始化----销毁的过程
     * 容器管理bean的生命周期；
     * 我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
     *
     * 构造（对象创建）
     * 		单实例：在容器启动的时候创建对象
     * 		多实例：在每次获取的时候创建对象\
     */
    @Test
    void test08() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(MyConfigOfLifeCycle.class);
        Object bean = context.getBean("car");
        System.out.println(bean);

        // ConfigurableApplicationContext 才有 close 方法
        context.close();
    }

    /**
     * 1）、指定初始化和销毁方法；
     * 		通过@Bean指定init-method和destroy-method；
     * 2）、通过让Bean实现InitializingBean（定义初始化逻辑），
     * 				DisposableBean（定义销毁逻辑）;
     */
    @Test
    void test09() {
        // Bean 实现 InitializingBean 和 DisposableBean 接口，实现初始化和销毁
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfigOfLifeCycle.class);
        context.close();
    }

}
