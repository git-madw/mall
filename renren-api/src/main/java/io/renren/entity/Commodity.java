package io.renren.entity;

import java.util.Date;

/**
 * @program: shop
 * @description: 商品类javabean
 * @author: dinggc
 * @create: 2019-03-09 11:20
 **/
public class Commodity extends BaseEntity{
    private String commodityName;
    private String commodityPicture;
    private Long classificationFirstId;
    private Long classificationSecondId;
    private String brandId;
    private Date date;
    private String description;

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityPicture() {
        return commodityPicture;
    }

    public void setCommodityPicture(String commodityPicture) {
        this.commodityPicture = commodityPicture;
    }

    public Long getClassificationFirstId() {
        return classificationFirstId;
    }

    public void setClassificationFirstId(Long classificationFirstId) {
        this.classificationFirstId = classificationFirstId;
    }

    public Long getClassificationSecondId() {
        return classificationSecondId;
    }

    public void setClassificationSecondId(Long classificationSecondId) {
        this.classificationSecondId = classificationSecondId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
