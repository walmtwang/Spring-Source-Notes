package com.postprocessor;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by walmt on 2017/7/27.
 */
public class PropertyConfigurerDemo {

//    public static void main(String[] args) {
//
//        ConfigurableListableBeanFactory bf =  new XmlBeanFactory(new ClassPathResource("com/postprocessor/BeanFactory.xml"));
//
//        BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor) bf.getBean("bfpp");
//        bfpp.postProcessBeanFactory(bf);
//        System.out.println(bf.getBean("simpleBean"));
//    }

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("com/postprocessor/BeanFactory.xml");

        SimplePostProcessor spp = (SimplePostProcessor) bf.getBean("simpleBean");
        System.out.println(spp);
    }
}
