package io.renren.entity;

import java.util.Date;

/**
 * @program: shop
 * @description: 属性名
 * @author: dinggc
 * @create: 2019-03-10 13:46
 **/
public class Attribute extends BaseEntity{
    private String attrName;
    private String isUse;
    private String classificationSecondId;
    private Date date;

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getIsUse() {
        return isUse;
    }

    public void setIsUse(String isUse) {
        this.isUse = isUse;
    }

    public String getClassificationSecondId() {
        return classificationSecondId;
    }

    public void setClassificationSecondId(String classificationSecondId) {
        this.classificationSecondId = classificationSecondId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
