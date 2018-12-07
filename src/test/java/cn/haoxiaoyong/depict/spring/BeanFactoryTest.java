package cn.haoxiaoyong.depict.spring;

import cn.haoxiaoyong.depict.spring.factory.AbstractBeanFactory;
import cn.haoxiaoyong.depict.spring.factory.AutowireCapableBeanFactory;
import cn.haoxiaoyong.depict.spring.factory.BeanFactory;
import cn.haoxiaoyong.depict.spring.io.ResourceLoader;
import cn.haoxiaoyong.depict.spring.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
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
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("depict.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            String key = beanDefinitionEntry.getKey();
            BeanDefinition value = beanDefinitionEntry.getValue();
            beanFactory.registerBeanDefinition(key, value);
        }
        beanFactory.preInstantiateSingletons();
        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();

    }


}
