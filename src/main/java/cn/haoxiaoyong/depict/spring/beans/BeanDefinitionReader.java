package cn.haoxiaoyong.depict.spring.beans;

import java.io.IOException;

/**
 * Created by haoxy on 2018/12/5.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
