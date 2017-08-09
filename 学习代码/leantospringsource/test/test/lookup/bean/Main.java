package test.lookup.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by walmt on 2017/7/12.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("test/lookup/lookupTest.xml");
        GetBeanTest test = (GetBeanTest) bf.getBean("getBeanTest");
        test.showMe();
    }
}
