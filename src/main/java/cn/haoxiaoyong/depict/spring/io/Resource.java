package cn.haoxiaoyong.depict.spring.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource 是 spring 内部定义资源的接口
 * Created by haoxy on 2018/12/5.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
