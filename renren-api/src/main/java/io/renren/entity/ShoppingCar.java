package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 购物车实体类题
 */
public class ShoppingCar extends BaseEntity{
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 商品价格
     */
    private BigDecimal skuPrice;
    /**
     * 商品件数
     */
    private int skuNumber;
    /**
     * 总价格
     */
    private BigDecimal totalPrice;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 商品id
     */
    private Long commodityId;
    /**
     * skuId
     */
    private Long skuId;
    /**
     * 是否选中
     */
    private String isChoose;
    /**
     * 商品图片
     */
    private String commodityPicture;
    /**
     * 商品规格
     */
    /**
     * 库存地址
     */
    private String inStockAddress;
    private Long color;
    /**
     * 时间
     * @return
     */
    private Date date;

    public String getInStockAddress() {
        return inStockAddress;
    }

    public void setInStockAddress(String inStockAddress) {
        this.inStockAddress = inStockAddress;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getColor() {
        return color;
    }

    public void setColor(Long color) {
        this.color = color;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSkuNumber() {
        return skuNumber;
    }

    public void setSkuNumber(int skuNumber) {
        this.skuNumber = skuNumber;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIsChoose() {
        return isChoose;
    }

    public void setIsChoose(String isChoose) {
        this.isChoose = isChoose;
    }

    public String getCommodityPicture() {
        return commodityPicture;
    }

    public void setCommodityPicture(String commodityPicture) {
        this.commodityPicture = commodityPicture;
    }
}
