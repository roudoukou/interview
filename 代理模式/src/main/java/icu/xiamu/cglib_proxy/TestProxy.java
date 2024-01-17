package icu.xiamu.cglib_proxy;

import org.junit.Test;

public class TestProxy {
    @Test
    public void testCglibProxy() {
        // 目标对象
        UserDao userDao = new UserDao();
        System.out.println(userDao.getClass());

        // 代理对象
        ProxyFactory proxyFactory = new ProxyFactory(userDao);
        UserDao proxy = (UserDao) proxyFactory.getProxyInstance();
        System.out.println(proxy.getClass());
        // 执行代理对象方法
        proxy.save();

        /*
        class icu.xiamu.cglib_proxy.UserDao
        class icu.xiamu.cglib_proxy.UserDao$$EnhancerByCGLIB$$9d7860a4
        开启事务
        保存数据
        关闭事务
         */
    }
}
