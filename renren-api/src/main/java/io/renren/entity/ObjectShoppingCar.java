package io.renren.entity;

/**
 * 购物车扩展类
 */
public class ObjectShoppingCar extends ShoppingCar{
    /**
     * sku
     */
    private Sku sku;
    /**
     * 商品颜色
     */
    private CommodityColor commodityColor;
    /**
     * 商品版本
     */
    private CommodityVersion commodityVersion;

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public CommodityColor getCommodityColor() {
        return commodityColor;
    }

    public void setCommodityColor(CommodityColor commodityColor) {
        this.commodityColor = commodityColor;
    }

    public CommodityVersion getCommodityVersion() {
        return commodityVersion;
    }

    public void setCommodityVersion(CommodityVersion commodityVersion) {
        this.commodityVersion = commodityVersion;
    }
}
