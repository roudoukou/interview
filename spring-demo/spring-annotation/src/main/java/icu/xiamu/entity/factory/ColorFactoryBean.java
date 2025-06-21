package icu.xiamu.entity.factory;

import icu.xiamu.entity.Color;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author roudoukou
 * @date 2025/6/16
 */
public class ColorFactoryBean implements FactoryBean<Color> {

    @Override
    public Color getObject() throws Exception {
        System.out.println("color 被创建");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        // 默认单例
        return FactoryBean.super.isSingleton();
        // return false;
    }
}
