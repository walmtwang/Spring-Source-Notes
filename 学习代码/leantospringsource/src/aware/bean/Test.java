package aware.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Created by walmt on 2017/7/23.
 */
public class Test implements BeanFactoryAware {
    private BeanFactory beanFactory;

    //声明bean的时候Spring会自动注入BeanFactory
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void testAware() {
        //通过hello这个bean id从beanFactory获取实例
        Hello hello = (Hello) beanFactory.getBean("hello");
        hello.say();
    }
}
