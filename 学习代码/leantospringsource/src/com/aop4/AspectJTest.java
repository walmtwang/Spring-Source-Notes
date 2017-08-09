package com.aop4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by walmt on 2017/8/4.
 */
@Aspect
public class AspectJTest {

    @Pointcut("execution(* *.testBeanM(..))")
    public void test() {

    }

    @Around("test()")
    public Object arountTest(ProceedingJoinPoint p) {
        System.out.println("before1");
        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after1");
        return o;
    }

}
