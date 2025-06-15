package icu.xiamu.config;

import icu.xiamu.condition.LinuxCondition;
import icu.xiamu.condition.MyImportBeanDefinitionRegistrar;
import icu.xiamu.condition.MyImportSelector;
import icu.xiamu.condition.WindowsCondition;
import icu.xiamu.entity.Color;
import icu.xiamu.entity.Person;
import icu.xiamu.entity.Red;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @author roudoukou
 * @date 2025/6/13
 */
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
@Configuration
public class MyConfig3 {

    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person person01() {
        return new Person("bill gates", 21);
    }

    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person02() {
        return new Person("linus", 20);
    }
}
