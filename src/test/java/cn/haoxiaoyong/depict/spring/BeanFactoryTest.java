package cn.haoxiaoyong.depict.spring;

import cn.haoxiaoyong.depict.spring.factory.AutowireCapableBeanFactory;
import cn.haoxiaoyong.depict.spring.factory.BeanFactory;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by haoxy on 2018/12/4.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class BeanFactoryTest {

    private Properties contextConfig = new Properties();

    @Test
    public void testBeanFactory() throws Exception {
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("cn.haoxiaoyong.depict.spring.HelloWorldService");
        //设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "HelloWorld"));
        beanDefinition.setPropertyValues(propertyValues);
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
        //获取 bean
        HelloWorldService helloWorldService1 = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService1.helloWorld();

    }
}
