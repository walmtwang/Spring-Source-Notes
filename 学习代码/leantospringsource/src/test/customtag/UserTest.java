package test.customtag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by walmt on 2017/7/16.
 */
public class UserTest {

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("test/customtag/Customtag.xml");
        User user = (User) bf.getBean("testBean");
        System.out.println(user.getUserName() + "," + user.getEmail());
    }
}
