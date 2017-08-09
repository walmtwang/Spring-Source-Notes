package com.bean;

/**
 * Created by walmt on 2017/7/18.
 */
public class TestC {

    private TestA testA;

    public TestC() {
    }

    public TestC(TestA testA) {
        this.testA = testA;
    }

    public void c() {
        testA.a();
    }

    public TestA getTestA() {
        return testA;
    }

    public void setTestA(TestA testA) {
        this.testA = testA;
    }
}
