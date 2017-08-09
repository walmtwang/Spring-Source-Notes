package com.messagesource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by walmt on 2017/8/2.
 */
public class MessageSourceTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/messagesource/applicationContext.xml");
        Object[] params = {"Join", new GregorianCalendar().getTime(), 1.0E3};

        String str1 = ctx.getMessage("test", params, Locale.US);
        String str2 = ctx.getMessage("test", params, Locale.CHINA);
        System.out.println(str1);
        System.out.println(str2);
    }
}
