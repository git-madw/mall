/**
 * FileName: ProductionService
 * Author:   dinggc
 * Date:     2019/7/29 22:29
 * Description: 商品的操作接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package io.renren.service;

import io.renren.entity.CommodityColor;
import io.renren.entity.CommodityVersion;
import io.renren.entity.ObjectCommodity;
import io.renren.entity.ObjectCommodityInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈商品的操作接口〉
 *
 * @author dinggc
 * @create 2019/7/29
 * @since 1.0.0
 */
public interface ProductionService {
    /***
     * 获取所有的商品信息
     * @param userId
     * @return
     */
    List<ObjectCommodity> getProductions(Long userId);
    /**
     * 功能描述: <br>
     * 〈获取商品的颜色〉
     * @Param: [commodityId]
     * @Return: io.renren.entity.ObjectCommodityInfo
     * @Author: dinggc
     * @Date: 2019/7/30 20:58
     */
    List<CommodityColor> getCommodityColor(String commodityId);
    /**
     * 功能描述: <br>
     * 〈获取商品的版本〉
     * @Param: [commodityId]
     * @Return: io.renren.entity.ObjectCommodityInfo
     * @Author: dinggc
     * @Date: 2019/7/30 20:58
     */
    List<CommodityVersion> getCommodityVersion(String commodityId);
}
