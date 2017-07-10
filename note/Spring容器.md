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

- `BeanFactory br = new XmlBeanFactory(new ClassPathResource("config/spring.xml"));`其中包含的过程
- XMLBeanFactory初始化时序图。![](https://github.com/walmt/img/blob/master/img/4.png?raw=true)

### ClassPathResource

- Spring的配置文件通过ClassPathResource进行封装。
- 在Java中，将不同来源的资源抽象成URL，通过注册不同的handler（URLStreamHandler）来处理。
- 一般handler的类型使用不同前缀来识别，然而URL没有默认定义相对ClassPath或ServletContext等资源的handler，虽然可以注册自己的URLStreamHandler，但需要了解URL实现机制以及URL也没提供一些基本方法（如检查当前资源是否存在，是否可读等），因而Spring对其内部使用到的资源实现了自己的抽象结构：Resource接口来封装底层资源。

```Java

public interface InputStreamSource {
    InputStream getInputStream() throws IOException;
}


public interface Resource extends InputStreamSource {
    boolean exists();

    boolean isReadable();

    boolean isOpen();

    URL getURL() throws IOException;

    URI getURI() throws IOException;

    File getFile() throws IOException;

    long contentLength() throws IOException;

    long lastModified() throws IOException;

    Resource createRelative(String var1) throws IOException;

    String getFilename();

    String getDescription();
}
```