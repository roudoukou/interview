package icu.xiamu;

import icu.xiamu.config.*;
import icu.xiamu.entity.Car;
import icu.xiamu.entity.Color;
import icu.xiamu.entity.Person;
import icu.xiamu.entity.factory.ColorFactoryBean;
import icu.xiamu.repository.BookRepository;
import icu.xiamu.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.ScopeNotActiveException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.text.spi.CollatorProvider;
import java.util.Arrays;
import java.util.EventListener;
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
     * bean的生命周期：
     * 		bean创建---初始化----销毁的过程
     * 容器管理bean的生命周期；
     * 我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
     *
     * 构造（对象创建）
     * 		单实例：在容器启动的时候创建对象
     * 		多实例：在每次获取的时候创建对象\
     *
     * BeanPostProcessor.postProcessBeforeInitialization
     * 初始化：
     * 		对象创建完成，并赋值好，调用初始化方法。。。
     * BeanPostProcessor.postProcessAfterInitialization
     * 销毁：
     * 		单实例：容器关闭的时候
     * 		多实例：容器不会管理这个bean；容器不会调用销毁方法；
     *
     *
     * 遍历得到容器中所有的BeanPostProcessor；挨个执行beforeInitialization，
     * 一但返回null，跳出for循环，不会执行后面的BeanPostProcessor.postProcessorsBeforeInitialization
     *
     * BeanPostProcessor原理
     * populateBean(beanName, mbd, instanceWrapper);给bean进行属性赋值
     * initializeBean
     * {
     * applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
     * invokeInitMethods(beanName, wrappedBean, mbd);执行自定义初始化
     * applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
     *}
     *
     *
     *
     * 1）、指定初始化和销毁方法；
     * 		通过@Bean指定init-method和destroy-method；
     * 2）、通过让Bean实现InitializingBean（定义初始化逻辑），
     * 				DisposableBean（定义销毁逻辑）;
     * 3）、可以使用JSR250；
     * 		@PostConstruct：在bean创建完成并且属性赋值完成；来执行初始化方法
     * 		@PreDestroy：在容器销毁bean之前通知我们进行清理工作
     * 4）、BeanPostProcessor【interface】：bean的后置处理器；
     * 		在bean初始化前后进行一些处理工作；
     * 		postProcessBeforeInitialization:在初始化之前工作
     * 		postProcessAfterInitialization:在初始化之后工作
     *
     * Spring底层对 BeanPostProcessor 的使用；
     * 		bean赋值，注入其他组件，@Autowired，生命周期注解功能，@Async,xxx BeanPostProcessor;
     *
     */
    @Test
    void test09() {
        // Bean 实现 InitializingBean 和 DisposableBean 接口，实现初始化和销毁
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfigOfLifeCycle.class);
        context.close();
    }

    /**
     * 属性赋值 @Value 注解的使用
     //使用@Value赋值；
     //1、基本数值
     //2、可以写SpEL； #{}
     //3、可以写${}；取出配置文件【properties】中的值（在运行环境变量里面的值）
     */
    @Test
    void test10() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfigOfPropertyValue.class);
        Object bean = context.getBean("person");
        System.out.println(bean);

        Environment environment = context.getEnvironment();
        String nickname = environment.getProperty("person.nickname");
        System.out.println(nickname);
    }

    /**
     * @Autowired 注解的使用
    /**
     * 自动装配;
     * 		Spring利用依赖注入（DI），完成对IOC容器中中各个组件的依赖关系赋值；
     *
     * 1）、@Autowired：自动注入：
     * 		1）、默认优先按照类型去容器中找对应的组件:applicationContext.getBean(BookDao.class);找到就赋值
     * 		2）、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
     * 							applicationContext.getBean("bookDao")
     * 		3）、@Qualifier("bookDao")：使用@Qualifier指定需要装配的组件的id，而不是使用属性名
     * 		4）、自动装配默认一定要将属性赋值好，没有就会报错；
     * 			可以使用@Autowired(required=false);
     * 		5）、@Primary：让Spring进行自动装配的时候，默认使用首选的bean；
     * 				也可以继续使用@Qualifier指定需要装配的bean的名字
     * 		BookService{
     * 			@Autowired
     * 			BookDao  bookDao;
     * 		}
     * 2）、Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[java规范的注解]
     * 		@Resource:
     * 			可以和@Autowired一样实现自动装配功能；默认是按照组件名称进行装配的；
     * 			没有能支持@Primary功能没有支持@Autowired（reqiured=false）;
     * 		@Inject:
     * 			需要导入javax.inject的包，和Autowired的功能一样。没有required=false的功能；
     *  @Autowired:Spring定义的； @Resource、@Inject都是java规范
     * 3）、 @Autowired:构造器，参数，方法，属性；都是从容器中获取参数组件的值
     * 		1）、[标注在方法位置]：@Bean+方法参数；参数从容器中获取;默认不写@Autowired效果是一样的；都能自动装配
     * 		2）、[标在构造器上]：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取
     * 		3）、放在参数位置：
     *
     *
     * AutowiredAnnotationBeanPostProcessor:解析完成自动装配功能；
     */
    @Test
    void test11() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfigOfAutowired.class);
        BookService bean = context.getBean(BookService.class);
        System.out.println(bean);

        // BookRepository bean1 = context.getBean(BookRepository.class);
        // System.out.println(bean1);

        Object boss = context.getBean("boss");
        System.out.println("boss: " + boss);

        Car car = context.getBean(Car.class);
        System.out.println(car);

        Color color = (Color) context.getBean("color");
        System.out.println(color);
    }


}
