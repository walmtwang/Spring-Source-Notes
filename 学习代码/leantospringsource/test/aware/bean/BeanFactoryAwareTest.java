package aware.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by walmt on 2017/7/23.
 */
public class BeanFactoryAwareTest {

    @org.junit.Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aware/bean/applicationContext.xml");
        Test test = (Test) context.getBean("test");
        test.testAware();
    }
}
