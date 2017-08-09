package com.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by walmt on 2017/8/2.
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/listener/applicationContext.xml");

        TestEvent event = new TestEvent("hello", "msg");
        context.publishEvent(event);
    }
}
