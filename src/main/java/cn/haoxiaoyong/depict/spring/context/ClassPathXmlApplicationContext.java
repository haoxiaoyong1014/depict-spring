package cn.haoxiaoyong.depict.spring.context;

import cn.haoxiaoyong.depict.spring.beans.BeanDefinition;
import cn.haoxiaoyong.depict.spring.beans.factory.AbstractBeanFactory;
import cn.haoxiaoyong.depict.spring.beans.factory.AutowireCapableBeanFactory;
import cn.haoxiaoyong.depict.spring.beans.io.ResourceLoader;
import cn.haoxiaoyong.depict.spring.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * Created by haoxiaoyong on 2018/12/9.
 * haodxy
 */
public class ClassPathXmlApplicationContext extends AbstractApplictionContext {


    private String location;

    public ClassPathXmlApplicationContext(String location) {
        this(location, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String location, AbstractBeanFactory beanFactory) {
        super(beanFactory);
        this.location = location;
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(location);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            String key = beanDefinitionEntry.getKey();
            BeanDefinition value = beanDefinitionEntry.getValue();
            beanFactory.registerBeanDefinition(key, value);
        }
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {

    }
}

