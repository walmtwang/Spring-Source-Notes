package com.bean;

/**
 * Created by walmt on 2017/7/18.
 */
public class TestA {

    private TestB testB;

    public TestA() {
    }

    public TestA(TestB testB) {
        this.testB = testB;
    }

    public void a() {
        testB.b();
    }

    public TestB getTestB() {
        return testB;
    }

    public void setTestB(TestB testB) {
        this.testB = testB;
    }
}
