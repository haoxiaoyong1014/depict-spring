package cn.haoxiaoyong.depict.spring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by haoxy on 2018/12/4.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class BeanFactory {

    private Map<String, BeanDefinitinon> beanDefinitinonMap = new ConcurrentHashMap<String, BeanDefinitinon>();

    public Object getBean(String name) {
        return beanDefinitinonMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinitinon beanDefinitinon) {
        beanDefinitinonMap.put(name, beanDefinitinon);
    }
}
