package aware.bean;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by walmt on 2017/7/23.
 */
public class Hello {

    @Resource(name = "test")
    private Test test;

    public void say() {
        System.out.println(test);
    }
}
