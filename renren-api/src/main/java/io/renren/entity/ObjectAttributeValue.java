package io.renren.entity;

import java.util.List;

/**
 * @program: shop
 * @description: 扩展的属性值类
 * @author: dinggc
 * @create: 2019-03-10 15:04
 **/
public class ObjectAttributeValue extends BaseEntity{
    private List<ObjectAttribute> attributes;

    public List<ObjectAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ObjectAttribute> attributes) {
        this.attributes = attributes;
    }
}
