/**
 * Copyright (C), 2015-2019
 * FileName: Sku
 * Author:   A
 * Date:     2019/3/14 13:38
 * Description: 商品的shu类
 */
package io.renren.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈商品的shu类〉
 * @author A
 * @create 2019/3/14
 * @since 1.0.0
 */
public class Sku extends BaseEntity{
    private Long commodityId;
    private int inStock;
    private BigDecimal price;
    private String skuName;
    private int skuSalesVolume;
    private String inStockAddress;
    private Date date;

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public int getSkuSalesVolume() {
        return skuSalesVolume;
    }

    public void setSkuSalesVolume(int skuSalesVolume) {
        this.skuSalesVolume = skuSalesVolume;
    }

    public String getInStockAddress() {
        return inStockAddress;
    }

    public void setInStockAddress(String inStockAddress) {
        this.inStockAddress = inStockAddress;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
