package icu.xiamu.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author roudoukou
 * @date 2025/6/22
 */
@Aspect
public class LogAspects {

    private static final Log log = LogFactory.getLog(LogAspects.class);

    // execution 表示某个方法的执行, MathCalculator.* 表示当前类下所有的方法, (..) 表示所有参数
    @Pointcut("execution(* icu.xiamu.aop.MathCalculator.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    // @Before("execution(* icu.xiamu.aop.MathCalculator.*(..))")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        log.info(joinPoint.getSignature().getName()+" 运行, @Before 参数列表是" + Arrays.asList(args));
    }

    @After("icu.xiamu.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature().getName()+" 运行, @After 结束");
    }

    @AfterReturning(value = "execution(public int icu.xiamu.aop.MathCalculator.*(..))", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        log.info(joinPoint.getSignature().getName()+" 运行, @AfterReturning 返回值是" + result);
    }

    @AfterThrowing(value = "execution(public int icu.xiamu.aop.MathCalculator.*(..))", throwing = "e")
    public void logException(JoinPoint joinPoint, Throwable e) {
        log.info(joinPoint.getSignature().getName()+" 运行, @AfterThrowing 异常是" + e);
    }

}
