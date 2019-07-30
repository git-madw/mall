/**
 * Copyright (C), 2015-2019
 * FileName: SkuAttributeValue
 * Author:   A
 * Date:     2019/3/14 13:40
 * Description: 商品sku数值型
 */
package io.renren.entity;

import java.util.Date;

/**
 * 〈商品sku属性值〉
 * @author A
 * @create 2019/3/14
 * @since 1.0.0
 */
public class SkuAttributeValue extends BaseEntity{
    private String attrId;
    private String attrValueId;
    private String commodityId;
    private String isSku;
    private String skuId;
    private Date date;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    public String getAttrValueId() {
        return attrValueId;
    }

    public void setAttrValueId(String attrValueId) {
        this.attrValueId = attrValueId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getIsSku() {
        return isSku;
    }

    public void setIsSku(String isSku) {
        this.isSku = isSku;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
