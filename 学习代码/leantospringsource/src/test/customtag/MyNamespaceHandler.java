package test.customtag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by walmt on 2017/7/16.
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
