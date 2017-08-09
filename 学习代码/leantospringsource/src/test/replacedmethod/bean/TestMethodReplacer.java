package test.replacedmethod.bean;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * Created by walmt on 2017/7/12.
 */
public class TestMethodReplacer implements MethodReplacer {


    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("我替换了原有的方法");
        return null;
    }
}
