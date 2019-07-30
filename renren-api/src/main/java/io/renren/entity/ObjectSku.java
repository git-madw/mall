/**
 * FileName: ObjectSku
 * Author:   dinggc
 * Date:     2019/7/29 22:25
 * Description: sku的扩展类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package io.renren.entity;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈sku的扩展类〉
 *
 * @author dinggc
 * @create 2019/7/29
 * @since 1.0.0
 */
public class ObjectSku extends Sku{
    /**
     * 商品的颜色
     */
    private List<CommodityColor> commodityColors;
    /**
     * 商品的版本
     */
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