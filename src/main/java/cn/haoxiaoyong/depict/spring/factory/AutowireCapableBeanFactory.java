package cn.haoxiaoyong.depict.spring.factory;

import cn.haoxiaoyong.depict.spring.BeanDefinitinon;

/**
 * Created by haoxy on 2018/12/4.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    protected Object doCreateBean(BeanDefinitinon beanDefinitinon) {

        Class beanClass = beanDefinitinon.getBeanClass();
        try {
            Object bean = beanClass.newInstance();    //反射,根据无参创建对象
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
