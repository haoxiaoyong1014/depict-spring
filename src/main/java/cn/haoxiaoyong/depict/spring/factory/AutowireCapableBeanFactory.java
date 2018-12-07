package cn.haoxiaoyong.depict.spring.factory;

import cn.haoxiaoyong.depict.spring.BeanDefinition;
import cn.haoxiaoyong.depict.spring.BeanReference;
import cn.haoxiaoyong.depict.spring.PropertyValue;
import cn.haoxiaoyong.depict.spring.PropertyValues;

import java.lang.reflect.Field;

/**
 * Created by haoxy on 2018/12/4.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 * 自动装载 BeanFactory
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {

        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    private Object createBeanInstance(BeanDefinition beanDefinition) {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            Object obj = beanClass.newInstance();
            return obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {

        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueList()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            Object value = propertyValue.getValue();
            if(value instanceof BeanReference){
                BeanReference beanReference = (BeanReference) value;
                 value = getBean(beanReference.getName());
            }
            declaredField.set(bean,value);
        }
    }
}
