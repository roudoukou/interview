package icu.xiamu.config;

import icu.xiamu.controller.BookController;
import icu.xiamu.entity.Person;
import icu.xiamu.filter.MyTypeFilter;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author roudoukou
 * @date 2025/6/13
 */
// @ComponentScan(value = "icu.xiamu", excludeFilters = {@ComponentScan.Filter(Controller.class)})
// @ComponentScan(value = "icu.xiamu", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(Controller.class)})
// @ComponentScan(value = "icu.xiamu", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(Controller.class), @ComponentScan.Filter(Service.class)})
// @ComponentScans(
//         {
//                 @ComponentScan(value = "icu.xiamu", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(Controller.class)}),
//                 @ComponentScan(value = "icu.xiamu", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(classes = Service.class, type = FilterType.ANNOTATION)})
//         }
// )

// @ComponentScan(value = "icu.xiamu", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(classes = Controller.class, type = FilterType.ANNOTATION)})
// @ComponentScan(value = "icu.xiamu", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(classes = BookController.class, type = FilterType.ASSIGNABLE_TYPE)})
// @ComponentScan(value = "icu.xiamu", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "icu.xiamu.controller.*")})
// @ComponentScan(value = "icu.xiamu", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = "icu.xiamu.controller.*")})









@ComponentScan(value = "icu.xiamu", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class)})
@Configuration
public class MyConfig {

    @Bean("peiqi")
    public Person person() {
        return new Person("huanglei123", 17);
    }
}
