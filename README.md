该项目仅仅是一个spring的测试项目，里面涉及了对spring拓展的运用，
通过对spring拓展的运用，来实现spi的技术。其中有三种方式去实现。
1.通过继承BeanDefinitionRegistryPostProcessor类
在spring加载PostProcessor类型类的时候，自动执行postProcessBeanDefinitionRegistry方法
拿到BeanDefinitionRegistry，也就是BeanDefinition注册器，接着自己生成
BeanDefinition来实现BeanDefinition的注册。
2.通过继承BeanDefinitionRegistryPostProcessor类，自动执行postProcessBeanFactory方法的时候
拿到beanFactory，并且通过beanFactory注册BeanDefinition来实现
3.通过实现继承importselect,在扫描注解@import的时候。执行selectImports方法，来实现类的注册。