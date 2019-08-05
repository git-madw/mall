package io.renren.modules.instock.service;

import io.renren.common.service.CrudService;
import io.renren.modules.instock.dto.CCommodityMemberDTO;
import io.renren.modules.instock.dto.CSkuDTO;
import io.renren.modules.instock.entity.CSkuEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * sku库存表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-04
 */
public interface CSkuService extends CrudService<CSkuEntity, CSkuDTO> {
    /**
     * 保存库存商品的会员价格
     * @param dto
     */
    void saveMemberPrice(CCommodityMemberDTO dto);
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
    void updateMemberInfo(CCommodityMemberDTO dto);
    /**
     * 获取库存的商品id
     * @param id
     * @return
     */
    Long getCommodityIdById(Long id);
    /**
     * 删除库存商品的相关会员信息
     * @param commodityId
     */
    void deleteMemberInfo(Long commodityId);
}