package io.renren.entity;

import java.util.Date;

/**
 * @program: shop
 * @description: 属性值
 * @author: dinggc
 * @create: 2019-03-10 13:48
 **/
public class AttributeValue extends BaseEntity{
    private String attrValue;
    private String isUse;
    private String attrId;
    private String attrCompany;
    private Date date;

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public String getIsUse() {
        return isUse;
    }

    public void setIsUse(String isUse) {
        this.isUse = isUse;
    }

    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    public String getAttrCompany() {
        return attrCompany;
    }

    public void setAttrCompany(String attrCompany) {
        this.attrCompany = attrCompany;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
