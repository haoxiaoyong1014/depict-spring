package cn.haoxiaoyong.depict.spring.factory;

import cn.haoxiaoyong.depict.spring.BeanDefinitinon;

/**
 * Created by haoxy on 2018/12/4.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public interface BeanFactory {

    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinitinon beanDefinitinon);

}
