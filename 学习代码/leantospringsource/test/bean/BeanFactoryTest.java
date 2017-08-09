package bean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by walmt on 2017/7/9.
 */
@SuppressWarnings("deprecation")
public class BeanFactoryTest {

    @Test
    public void testSimpleLoad() throws IOException {

        BeanFactory br = new XmlBeanFactory(new ClassPathResource("config/spring.xml"));
        MyTestBean bean = (MyTestBean) br.getBean("myTestBean");
        System.out.println(bean.getTestStr());
        Resource resource = new ClassPathResource("config/spring.xml");
        InputStream inputStream = resource.getInputStream();
        MyTestBean myTestBean = new MyTestBean();
    }
}
