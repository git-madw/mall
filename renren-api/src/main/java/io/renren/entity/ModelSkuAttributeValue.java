/**
 * Copyright (C), 2015-2019
 * FileName: ModelSkuAttributeValue
 * Author:   A
 * Date:     2019/3/14 15:30
 * Description: 封装ObjectSku信息
 */
package io.renren.entity;

import java.util.List;

/**
 * 〈封装ObjectSku信息〉
 * @author A
 * @create 2019/3/14
 * @since 1.0.0
 */
public class ModelSkuAttributeValue {
    private List<ObjectSkuAttributeValue> objectSkuAttributeValues;

    public List<ObjectSkuAttributeValue> getObjectSkuAttributeValues() {
        return objectSkuAttributeValues;
    }

    public void setObjectSkuAttributeValues(List<ObjectSkuAttributeValue> objectSkuAttributeValues) {
        this.objectSkuAttributeValues = objectSkuAttributeValues;
    }
}
