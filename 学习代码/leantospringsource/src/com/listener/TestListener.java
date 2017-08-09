package com.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by walmt on 2017/8/2.
 */
public class TestListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof TestEvent) {
            TestEvent testEvent = (TestEvent) event;
            testEvent.print();
        }
    }
}
