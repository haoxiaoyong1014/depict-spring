package cn.haoxiaoyong.depict.spring.beans.xml;

import cn.haoxiaoyong.depict.spring.beans.BeanDefinition;
import cn.haoxiaoyong.depict.spring.beans.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by haoxy on 2018/12/5.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xml=new XmlBeanDefinitionReader(new ResourceLoader());
        xml.loadBeanDefinitions("depict.xml");
        Map<String, BeanDefinition> registry = xml.getRegistry();
        Assert.assertTrue(registry.size() > 0);

    }
}
