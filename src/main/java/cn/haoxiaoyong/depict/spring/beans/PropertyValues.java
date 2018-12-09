package cn.haoxiaoyong.depict.spring.beans;

import java.util.*;

/**
 * Created by haoxy on 2018/12/5.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 * <p>
 * 包装一个对象存放所有的PropertyValue。<br/>
 * 为什么封装而不是直接用List?因为可以封装一些操作。
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues() {
    }

    public void addPropertyValue(PropertyValue pv) {
        propertyValueList.add(pv);
    }

    public List<PropertyValue> getPropertyValueList() {
        return this.propertyValueList;
    }
}
