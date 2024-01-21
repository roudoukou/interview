package com.atguigu.spring;

import com.atguigu.spring.service.CalcService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
// @RunWith(SpringRunner.class)
public class TestAop {
    @Resource
    CalcService calcService;

    @Test
    public void testAop4() {
        System.out.println("Spring版本: " + SpringVersion.getVersion());
        System.out.println("springboot版本: " + SpringBootVersion.getVersion());

        // calcService.div(10, 2);
        /*
        运行结果:
        Spring版本: 4.3.13.RELEASE
        springboot版本: 1.5.9.RELEASE
        我是环绕通知之前AAA
        ********@Before我是前置通知
        CalcServiceImpl被调用了, 我们的计算结果: 5
        我是环绕通知之后BBB
        ********@After我是后置通知
        ********@AfterReturning我是返回后通知
        */

        calcService.div(10, 0);
        /*
        运行结果:
        Spring版本: 4.3.13.RELEASE
        springboot版本: 1.5.9.RELEASE
        我是环绕通知之前AAA
        ********@Before我是前置通知
        ********@After我是后置通知
        ********@AfterThrowing我是异常通知

        java.lang.ArithmeticException: / by zero
         */
    }

    @Test
    public void testAop5() {
        System.out.println("Spring版本: " + SpringVersion.getVersion());
        System.out.println("springboot版本: " + SpringBootVersion.getVersion());

        // calcService.div(10, 2);
        /*
        运行结果:
        Spring版本: 5.2.8.RELEASE
        springboot版本: 2.3.3.RELEASE
        我是环绕通知之前AAA
        ********@Before我是前置通知
        CalcServiceImpl被调用了, 我们的计算结果: 5
        ********@AfterReturning我是返回后通知
        ********@After我是后置通知
        我是环绕通知之后BBB
        */

        calcService.div(10, 0);
        /*
        运行结果:
        Spring版本: 5.2.8.RELEASE
        springboot版本: 2.3.3.RELEASE
        我是环绕通知之前AAA
        ********@Before我是前置通知
        ********@AfterThrowing我是异常通知
        ********@After我是后置通知

        java.lang.ArithmeticException: / by zero
         */
    }
}
