package cn.haoxiaoyong.depict.spring;

import cn.haoxiaoyong.depict.spring.factory.AbstractBeanFactory;
import cn.haoxiaoyong.depict.spring.factory.AutowireCapableBeanFactory;
import cn.haoxiaoyong.depict.spring.factory.BeanFactory;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by haoxy on 2018/12/4.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class BeanFactoryTest {

    private Properties contextConfig = new Properties();
    private Object beans;

    @Test
    public void testBeanFactory() {
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        //注册 bean
        BeanDefinitinon beanDefinitinon = new BeanDefinitinon("cn.haoxiaoyong.depict.spring.HelloWorldService");
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinitinon);

        //获取 bean
        HelloWorldService helloWorldService1 = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService1.helloWorld();

    }

    /**
     * 在根目录下创建一个config.properties文件
     */
    @Test
    public void testBeanFactory_ConfigProperties() {
        doLoadConfig();
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Object scanKey : contextConfig.keySet()) {
            String packageClass = contextConfig.getProperty(String.valueOf(scanKey));
            BeanDefinitinon beanDefinitinon = new BeanDefinitinon(packageClass);
            try {
                Class<?> aClass = Class.forName(packageClass);
                String simpleName = aClass.getSimpleName();
                //Spring beanId 首字符小写(规范)
                String lowerName = lowerFirstCase(simpleName);
                beanFactory.registerBeanDefinition(lowerName, beanDefinitinon);
                //获取 bean
                Object object = aClass.newInstance();
                Method[] methods = aClass.getMethods();
                for (Method method : methods) {
                    method.invoke(object);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String lowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private void doLoadConfig() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("config.properties"));
            contextConfig.load(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
