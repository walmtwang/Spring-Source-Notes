# Spring核心类介绍

### 1.DefaultListableBeanFactory

- XmlBeanFactory继承于该类。
- DefaultListableBeanFactory是整个bean加载的核心部分，是Spring注册和加载bean的默认实现。
- XmlBeanFactory使用了自己定义的XML读取器XmlBeanDefinitionReader实现了个性化的BeanDefinitionReader读取。
- DefaultListableBeanFactory继承了AbstractAutowireCapableBeanFactory，实现了ConfigurableListableBeanFactory、BeanDefinitionRegistry接口。
- ![](https://github.com/walmt/img/blob/master/img/2.png?raw=true)

> AliasRegistry:定义对alias的简单增删改等操作。
> SimpleAliasRegister：使用map作为alias的缓存，实现AliasRegistry。
> SingletonBeanRegistry：定义单例的注册和获取。
> BeanFactory：定义获取Bean和Bean的各种属性。
