package icu.xiamu.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author roudoukou
 * @date 2025/6/21
 */
@Component
public class Cat implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("Cat 销毁方法。。。");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat 属性设置完之后，初始化方法。。。");
    }
}
