package icu.xiamu.dynamic_proxy;

import org.junit.Test;

public class TestProxy {
    @Test
    public void testDynamicProxy() {
        // 目标对象
        UseDao useDao = new UseDao();
        System.out.println(useDao.getClass()); // 输出目标对象信息
        // useDao.save();

        // 通过代理对象调用
        ProxyFactory proxyFactory = new ProxyFactory(useDao);
        IUserDao proxyInstance = (IUserDao) proxyFactory.getProxyInstance();
        System.out.println(proxyInstance.getClass());  // 输出代理对象信息
        proxyInstance.save();

        /*
        class icu.xiamu.dynamic_proxy.UseDao
        class com.sun.proxy.$Proxy4
        开启事务
        保存数据
        关闭事务
         */

    }
}
