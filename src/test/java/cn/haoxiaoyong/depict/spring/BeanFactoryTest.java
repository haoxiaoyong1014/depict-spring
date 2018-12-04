package cn.haoxiaoyong.depict.spring;

import org.junit.Test;

/**
 * Created by haoxy on 2018/12/4.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class BeanFactoryTest {

    @Test
    public void testBeanFactory() {
        BeanFactory beanFactory = new BeanFactory();

        //注册 bean
        BeanDefinitinon beanDefinitinon = new BeanDefinitinon(new HelloWorldService());
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinitinon);

        //获取 bean
        HelloWorldService helloWorldService1 = (HelloWorldService)beanFactory.getBean("helloWorldService");
        helloWorldService1.helloWorld();

    }
}
