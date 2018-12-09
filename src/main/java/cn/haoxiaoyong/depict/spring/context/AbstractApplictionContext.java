package cn.haoxiaoyong.depict.spring.context;

import cn.haoxiaoyong.depict.spring.beans.factory.AbstractBeanFactory;

/**
 * Created by haoxiaoyong on 2018/12/9.
 * haoxy
 */
public abstract class AbstractApplictionContext implements ApplicationContext{

    protected AbstractBeanFactory beanFactory;

    public AbstractApplictionContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object getBean(String name) throws Exception {

        return beanFactory.getBean(name);
    }
    public void refresh() throws Exception{

    }
}
