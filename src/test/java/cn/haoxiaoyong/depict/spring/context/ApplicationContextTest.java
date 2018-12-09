package cn.haoxiaoyong.depict.spring.context;

import cn.haoxiaoyong.depict.spring.HelloWorldService;
import org.junit.Test;

/**
 * Created by haoxiaoyong on 2018/12/9.
 * hao
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("depict.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
