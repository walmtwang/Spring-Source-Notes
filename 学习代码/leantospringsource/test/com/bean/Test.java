package com.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by walmt on 2017/7/19.
 */
public class Test {

    @org.junit.Test
    public void testCircleByConstructor() throws Throwable {
//        try {
//            new ClassPathXmlApplicationContext("com/bean/spring-test.xml");
//        } catch (Exception e) {
//            //因为要在创建testC时抛出；
//            Throwable e1 = e.getCause().getCause().getCause();
//            throw e1;
//        }
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/bean/spring-test.xml");
            TestA testA = (TestA) ctx.getBean("testA");
            TestB testB = (TestB) ctx.getBean("testB");
            TestC testC = (TestC) ctx.getBean("testC");

            System.out.println(testA + ";" + testC.getTestA());
        } catch (Exception e) {
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }

}
