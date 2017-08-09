package com.aop3;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;

/**
 * Created by walmt on 2017/8/6.
 */
public class ProxyTest {

    @Test
    public void testProxy() {
        //实例化目标对象
        UserService userService = new UserServiceImpl();

        //实例化InvocationHandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);

        //根据目标对象生成代理对象
        UserService proxy = (UserService) invocationHandler.getProxy();

        //调用代理对象方法
        proxy.add();
    }
}
