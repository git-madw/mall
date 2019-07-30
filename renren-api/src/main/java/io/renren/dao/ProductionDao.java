/**
 * FileName: ProductionDao
 * Author:   dinggc
 * Date:     2019/7/29 22:19
 * Description: 商品dao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package io.renren.dao;

import io.renren.entity.CommodityColor;
import io.renren.entity.CommodityVersion;
import io.renren.entity.ObjectCommodity;
import io.renren.entity.ObjectCommodityInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈商品dao〉
 *
 * @author dinggc
 * @create 2019/7/29
 * @since 1.0.0
 */
public interface ProductionDao {
    /***
     * 获取所有的商品信息
     * @param userId
     * @return
     */
    List<ObjectCommodity> getProductions(@Param("userId") Long userId);
    /**
     * 功能描述: <br>
     * 〈获取商品的颜色〉
     * @Param: [commodityId]
     * @Return: io.renren.entity.ObjectCommodityInfo
     * @Author: dinggc
     * @Date: 2019/7/30 20:58
     */
    List<CommodityColor> getCommodityColor(@Param("commodityId") String commodityId);
    /**
     * 功能描述: <br>
     * 〈获取商品的版本〉
     * @Param: [commodityId]
     * @Return: io.renren.entity.ObjectCommodityInfo
     * @Author: dinggc
     * @Date: 2019/7/30 20:58
     */
    List<CommodityVersion> getCommodityVersion(@Param("commodityId") String commodityId);
}
