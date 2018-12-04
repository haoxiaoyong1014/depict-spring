package cn.haoxiaoyong.depict.spring.factory;

import cn.haoxiaoyong.depict.spring.BeanDefinitinon;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by haoxy on 2018/12/4.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinitinon> beanDefinitinonMap = new ConcurrentHashMap<String, BeanDefinitinon>();

    public Object getBean(String name) {
        return beanDefinitinonMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinitinon beanDefinitinon){

        Object bean = doCreateBean(beanDefinitinon);
        beanDefinitinon.setBean(bean);
        beanDefinitinonMap.put(name,beanDefinitinon);

    }

    protected abstract Object doCreateBean(BeanDefinitinon beanDefinitinon);


}
