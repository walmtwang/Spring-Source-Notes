package com.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by walmt on 2017/8/7.
 */
public class MethodInterceptorImpl implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("Before invoke " + method);
        Object result = methodProxy.invokeSuper(o, objects);
        System.err.println("After invoke " + method);
        return result;
    }
}
