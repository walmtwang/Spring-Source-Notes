package com.aop2;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by walmt on 2017/8/5.
 */
public class AServiceImpl1 implements AService {
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void a() {
        this.b();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void b() {
    }
}
