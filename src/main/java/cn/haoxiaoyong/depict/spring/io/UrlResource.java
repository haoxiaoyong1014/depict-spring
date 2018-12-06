package cn.haoxiaoyong.depict.spring.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by haoxy on 2018/12/5.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class UrlResource implements Resource{

    private final URL url;


    public UrlResource(URL url) {
        this.url=url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection=url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
