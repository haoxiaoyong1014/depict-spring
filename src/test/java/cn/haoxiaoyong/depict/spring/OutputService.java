package cn.haoxiaoyong.depict.spring;

import org.junit.Assert;

/**
 * Created by haoxy on 2018/12/6.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class OutputService {

    private HelloWorldService helloWorldService;

    public void output(String text){
        Assert.assertNotNull(helloWorldService);
        System.out.println(text);
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
