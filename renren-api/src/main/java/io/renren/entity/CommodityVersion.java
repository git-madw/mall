/**
 * Copyright (C), 2015-2019
 * FileName: CommodityVersion
 * Author:   A
 * Date:     2019/3/18 11:13
 * Description: 商品版本
 */
package io.renren.entity;

import java.util.Date;

/**
 * 〈商品版本〉
 * @author A
 * @create 2019/3/18
 * @since 1.0.0
 */
public class CommodityVersion extends BaseEntity{
    private String commodityId;
    private String commodityVersion;
    private int isUse;
    private Date date;

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityVersion() {
        return commodityVersion;
    }

    public void setCommodityVersion(String commodityVersion) {
        this.commodityVersion = commodityVersion;
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
}
