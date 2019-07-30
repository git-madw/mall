/**
 * Copyright (C), 2015-2019
 * FileName: CommodityColor
 * Author:   A
 * Date:     2019/3/18 11:11
 * Description: 商品的颜色
 */
package io.renren.entity;

import java.util.Date;

/**
 * 〈商品的颜色〉
 * @author A
 * @create 2019/3/18
 * @since 1.0.0
 */
public class CommodityColor extends BaseEntity{
    private String commodityId;
    private String commodityColor;
    private int isUse;
    private Date date;
    private String url;

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityColor() {
        return commodityColor;
    }

    public void setCommodityColor(String commodityColor) {
        this.commodityColor = commodityColor;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
