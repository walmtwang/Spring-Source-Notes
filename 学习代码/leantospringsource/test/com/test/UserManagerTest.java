package com.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by walmt on 2017/7/26.
 */
public class UserManagerTest {

    @Test
    public void testDate() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/test/applicationContext.xml");
        UserManager userManager = (UserManager) ctx.getBean("userManager");
        System.out.println(userManager);
    }

}
