package com.aop4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by walmt on 2017/8/4.
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("classpath:com/aop4/springaop.xml");
        IITestBean bean = (IITestBean) bf.getBean("test");
        bean.testBeanM();
    }
}
