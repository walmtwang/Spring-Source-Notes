# 容器的基础XmlBeanFactory

### 示例代码

```Java


//Bean类
public class MyTestBean {
    private String testStr = "testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }
}


// 测试
public class BeanFactoryTest {

    @Test
    public void testSimpleLoad() {
        BeanFactory br = new XmlBeanFactory(new ClassPathResource("config/spring.xml"));
        MyTestBean bean = (MyTestBean) br.getBean("myTestBean");
        System.out.println(bean.getTestStr());
    }
}
```

- `BeanFactory br = new XmlBeanFactory(new ClassPathResource("config/spring.xml"));`
- XMLBeanFactory初始化时序图。![](https://github.com/walmt/img/blob/master/img/4.png?raw=true)