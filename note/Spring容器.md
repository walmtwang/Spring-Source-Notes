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

### Resource&InputStream

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

##### InputStreamSource

- InputStreamSource封装了任何能返回InputStream的类，比如File、ClasPath下的资源和Byte Array等。
- 它只定义了一个方法：`getInputStream()`，该方法返回一个新的InputStream对象。

##### Resource

- Resource接口抽象了Spring内部使用到的底层资源：File、URL、Classpath等。
- 首先它定义了3个判断当前资源状态的方法：存在性（exists）、可读性（isReadable）、是否处于打开状态（isOpen）。
- 提供了不同资源到URL、URI、File类型的转换，以及获取lastModified属性、文件名（不带路径信息的文件名，`getFilename()`）的方法。
- 基于当前资源创建一个相对资源的方法：`createRelative()`。
- 用`getDescription()`在错误处理中打印信息。
- 对不同来源都有相应的Resource实现：

>- 文件（FileSystemResource）
>- Classpath资源（ClassPathResource）
>- URL资源（URLResource）
>- InputStream资源（InputStreamResource）
>- Byte数组（ByteArrayResource）等。

- ![](https://github.com/walmt/img/blob/master/img/5.png?raw=true)
- 日常开发中，可以直接使用Spring提供的类。

```Java

//例：
Resource resource = new ClassPathResource("config/spring.xml");
InputStream inputStream = resource.getInputStream();
```

### XmlBeanFactory的初始化

```Java

public XmlBeanFactory(Resource resource) throws BeansException {
	this(resource, null);
}

//使用Resource实例作为构造函数的办法
public XmlBeanFactory(Resource resource, BeanFactory parentBeanFactory) throws BeansException {
	super(parentBeanFactory);
	this.reader.loadBeanDefinitions(resource);
}
```

- `this.reader.loadBeanDefinitions(resource);`是资源加载器的真正实现。
- 跟踪`super(parentBeanFactory);`最终可看到：

```Java

public AbstractAutowireCapableBeanFactory() {
	super();
	ignoreDependencyInterface(BeanNameAware.class);
	ignoreDependencyInterface(BeanFactoryAware.class);
	ignoreDependencyInterface(BeanClassLoaderAware.class);
}
```

- `ignoreDependencyInterface()`方法主要功能是忽略给定接口的自动装配功能。

>- 举例：当A中有属性B，那么当Spring在获取A的Bean的时候如果其属性B还没有初始化，那么Spring会自动 初始化B，这也是Spring中提供的一个重要特性。
>- 但是，某种情况下B不会被初始化，其中一种是实现了BeanNameAware接口。
>- 原因：自动装配是忽略给定的依赖接口，典型应用是通过其他方法解析Application上下文注册依赖，类似于BeanFactory通过BeanFactoryAware进行注入或者ApplicationContext通过ApplicationContextAware进行注入。

### 加载Bean

- `this.reader.loadBeanDefinitions(resource);`这个方法的时序图：![](https://github.com/walmt/img/blob/master/img/6.png?raw=true)
- （1）封装资源文件。当进入XmlBeanDefinitionReader后首先对参数Resource使用EncodedResource类进行封装。
- （2）获取输入流。从Resource中获取对应的InputStream并构造InputSource。
- （3）通过构造的InputSource
