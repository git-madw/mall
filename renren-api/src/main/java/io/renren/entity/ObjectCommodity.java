package io.renren.entity;

import java.util.List;

/**
 * @program: shop
 * @description: 扩展的商品类
 * @author: dinggc
 * @create: 2019-03-09 11:29
 **/
public class ObjectCommodity extends Commodity{
    private Brand brand;
    private Sku sku;

    private List<CCommodityLbEntity> lbs;


    private ObjectCommodityInfo objectCommodityInfo;


    public List<CCommodityLbEntity> getLbs() {
        return lbs;
    }

    public void setLbs(List<CCommodityLbEntity> lbs) {
        this.lbs = lbs;
    }

    public ObjectCommodityInfo getObjectCommodityInfo() {
        return objectCommodityInfo;
    }

    public void setObjectCommodityInfo(ObjectCommodityInfo objectCommodityInfo) {
        this.objectCommodityInfo = objectCommodityInfo;
    }

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
