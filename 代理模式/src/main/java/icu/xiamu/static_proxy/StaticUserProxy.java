package icu.xiamu.static_proxy;

import org.junit.Test;

public class StaticUserProxy {
    @Test
    public void testStaticProxy() {
        // 目标对象
        UserDao userDao = new UserDao();
        // 代理对象
        IUserDao userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.save();
    }
}
