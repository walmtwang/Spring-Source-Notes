package test.lookup.bean;

/**
 * Created by walmt on 2017/7/12.
 */
public abstract class GetBeanTest {

    public void showMe() {
        this.getBean().showMe();
    }

    public abstract User getBean();
}
