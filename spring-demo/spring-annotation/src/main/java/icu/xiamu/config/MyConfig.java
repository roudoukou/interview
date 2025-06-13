package icu.xiamu.config;

import icu.xiamu.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author roudoukou
 * @date 2025/6/13
 */
// @ComponentScan(value = "icu.xiamu", excludeFilters = {@ComponentScan.Filter(Controller.class)})
// @ComponentScan(value = "icu.xiamu", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(Controller.class)})
// @ComponentScan(value = "icu.xiamu", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(Controller.class), @ComponentScan.Filter(Service.class)})
@ComponentScans(
        {
                @ComponentScan(value = "icu.xiamu", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(Controller.class)}),
                @ComponentScan(value = "icu.xiamu", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(Service.class)})
        }
)
@Configuration
public class MyConfig {

    @Bean("peiqi")
    public Person person() {
        return new Person("huanglei123", 17);
    }
}
