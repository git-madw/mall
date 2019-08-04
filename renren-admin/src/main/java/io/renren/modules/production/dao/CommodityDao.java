package io.renren.modules.production.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.production.dto.CCommodityLbDTO;
import io.renren.modules.production.dto.CommodityDTO;
import io.renren.modules.production.entity.CCommodityLbEntity;
import io.renren.modules.production.entity.CommodityEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 * 商品表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-02
 */
@Mapper
public interface CommodityDao extends BaseDao<CommodityEntity> {
    /**
     * 保存商品的轮播图片
     * @param entity
     */
    void saveLbPicture(@Param("entity") CCommodityLbEntity entity);
    /**
     * 功能描述: <br>
     * 〈获取商品的轮播图片〉
     * @Param: [id]
     * @Return: java.util.List<io.renren.modules.production.entity.CCommodityLbEntity>
     * @Author: dinggc
     * @Date: 2019/8/3 17:10
     */
    List<CCommodityLbDTO> getLbCommodity(@Param("id") Long id);
    /**
     * 功能描述: <br>
     * 〈删除商品的轮播图片〉
     * @Param: [id]
     * @Return: void
     * @Author: dinggc
     * @Date: 2019/8/3 18:17
     */
    void deleteLb(@Param("id") Long id);
    /**
     * 功能描述: <br>
     * 〈更新商品轮播图片〉
     * @Param: [dto]
     * @Return: void
     * @Author: dinggc
     * @Date: 2019/8/3 18:29
     */
    void updateLb(@Param("dto") CCommodityLbDTO dto);
    /**
     * 功能描述: <br>
     * 〈模糊查询商品名称〉
     * @Param: [key]
     * @Return: java.util.List<io.renren.modules.production.dto.CCommodityLbDTO>
     * @Author: dinggc
     * @Date: 2019/8/4 19:59
     */
    List<CommodityDTO> queryCommodity(@Param("key") String key);
}