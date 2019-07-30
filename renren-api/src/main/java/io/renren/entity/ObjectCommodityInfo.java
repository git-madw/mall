/**
 * Copyright (C), 2015-2019
 * FileName: ObjectCommodityInfo
 * Author:   A
 * Date:     2019/3/18 13:58
 * Description: 颜色和版本的封装；类
 */
package io.renren.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 〈颜色和版本的封装；类〉
 * @author A
 * @create 2019/3/18
 * @since 1.0.0
 */
public class ObjectCommodityInfo extends BaseEntity {
    private List<CommodityColor> commodityColors;
    private List<CommodityVersion> commodityVersions;

    public List<CommodityColor> getCommodityColors() {
        return commodityColors;
    }

    public void setCommodityColors(List<CommodityColor> commodityColors) {
        this.commodityColors = commodityColors;
    }

    public List<CommodityVersion> getCommodityVersions() {
        return commodityVersions;
    }

    public void setCommodityVersions(List<CommodityVersion> commodityVersions) {
        this.commodityVersions = commodityVersions;
    }
}
