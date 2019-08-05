package io.renren.modules.instock.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.instock.dto.CCommodityMemberDTO;
import io.renren.modules.instock.entity.CCommodityMemberEntity;
import io.renren.modules.instock.entity.CSkuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * sku库存表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-04
 */
@Mapper
public interface CSkuDao extends BaseDao<CSkuEntity> {
    /**
     * 保存库存商品的会员价格
     * @param dto
     */
    void saveMemberPrice(@Param("dto") CCommodityMemberDTO dto);

    /**
     * 获取当前库存信息的会员等级数量与价格
     * @param commodityId
     * @return
     */
    List<CCommodityMemberDTO> getMemberInfo(@Param("commodityId") Long commodityId);

    /**
     * 更新商品库存的会员等级和数量信息
     * @param dto
     */
    void updateMemberInfo(@Param("dto") CCommodityMemberDTO dto);

    /**
     * 获取库存的商品id
     * @param id
     * @return
     */
    Long getCommodityIdById(@Param("id") Long id);

    /**
     * 删除库存商品的相关会员信息
     * @param commodityId
     */
    void deleteMemberInfo(@Param("commodityId") Long commodityId);
}