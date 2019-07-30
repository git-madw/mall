package io.renren.entity;

import java.util.List;

/**
 * @program: shop
 * @description: 属性名的扩展类
 * @author: dinggc
 * @create: 2019-03-10 15:10
 **/
public class ObjectAttribute extends Attribute{
    private List<AttributeValue> attributeValues;

    public List<AttributeValue> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<AttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }
}
