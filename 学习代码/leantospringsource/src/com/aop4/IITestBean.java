package com.aop4;

/**
 * Created by walmt on 2017/8/4.
 */
public class IITestBean {

    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public void testBeanM() {
        System.out.println("test");
    }
}
