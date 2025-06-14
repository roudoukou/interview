package icu.xiamu.config;

import icu.xiamu.entity.Person;
import icu.xiamu.filter.MyTypeFilter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @author roudoukou
 * @date 2025/6/13
 */
@Configuration
public class MyConfig2 {

    // @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean("person")
    public Person person() {
        System.out.println("person对象创建中......");
        return new Person("huanglei123456", 17);
    }
}
