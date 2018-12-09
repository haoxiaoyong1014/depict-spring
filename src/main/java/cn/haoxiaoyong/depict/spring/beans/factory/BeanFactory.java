package cn.haoxiaoyong.depict.spring.beans.factory;

import cn.haoxiaoyong.depict.spring.beans.BeanDefinition;

/**
 * Created by haoxy on 2018/12/4.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 * bean 的容器
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;

}
