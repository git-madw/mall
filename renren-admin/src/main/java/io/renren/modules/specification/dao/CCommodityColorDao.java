package io.renren.modules.specification.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.production.dto.CCommodityLbDTO;
import io.renren.modules.specification.dto.CCommodityColorDTO;
import io.renren.modules.specification.entity.CCommodityColorEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-03
 */
@Mapper
public interface CCommodityColorDao extends BaseDao<CCommodityColorEntity> {
	/**
	 * 功能描述: <br>
	 * 〈获取所有未绑定的商品规格〉
	 * @Param: []
	 * @Return: java.util.List<io.renren.modules.specification.dto.CCommodityColorDTO>
	 * @Author: dinggc
	 * @Date: 2019/8/4 14:59
	 */
    List<CCommodityColorDTO> getSpecification();
    /**
     * 功能描述: <br>
     * 〈更新商品的规格〉
     * @Param: [cCommodityLbDTO]
     * @Return: void
     * @Author: dinggc
     * @Date: 2019/8/4 15:43
     */
    void updateCommodityColor(@Param("commodityId") Long commodityId,@Param("id") Long id);
    /**
     * 功能描述: <br>
     * 〈获取商品的规格〉
     * @Param: [id]
     * @Return: java.util.List<io.renren.modules.specification.dto.CCommodityColorDTO>
     * @Author: dinggc
     * @Date: 2019/8/4 16:23
     */
    List<CCommodityColorDTO> getProductionSpecification(@Param("id") Long id);
    /**
     * 功能描述: <br>
     * 〈删除商品规格〉
     * @Param: [id]
     * @Return: void
     * @Author: dinggc
     * @Date: 2019/8/4 16:58
     */
    void deleteSpec(@Param("id") Long id);
    /**
     * 功能描述: <br>
     * 〈根据商品id获取商品的规格〉
     * @Param: [commodityId]
     * @Return: java.util.List<io.renren.modules.specification.dto.CCommodityColorDTO>
     * @Author: dinggc
     * @Date: 2019/8/4 20:25
     */
    List<CCommodityColorDTO> getCommoditySpecification(@Param("commodityId") Long commodityId);
}