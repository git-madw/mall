/**
 * Copyright (C), 2015-2019
 * FileName: ObjectSkuAttributeValue
 * Author:   A
 * Date:     2019/3/14 15:25
 * Description: 扩展的sku属性值类
 */
package io.renren.entity;

import java.util.List;

/**
 * 〈扩展的sku属性值类〉
 * @author A
 * @create 2019/3/14
 * @since 1.0.0
 */
public class ObjectSkuAttributeValue{
    private Attribute attribute;
    private List<AttributeValue> attributeValues;

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public List<AttributeValue> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<AttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }
}
