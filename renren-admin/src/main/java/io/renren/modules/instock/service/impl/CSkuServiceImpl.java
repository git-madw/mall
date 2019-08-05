package io.renren.modules.instock.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.instock.dao.CSkuDao;
import io.renren.modules.instock.dto.CCommodityMemberDTO;
import io.renren.modules.instock.dto.CSkuDTO;
import io.renren.modules.instock.entity.CSkuEntity;
import io.renren.modules.instock.service.CSkuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * sku库存表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-04
 */
@Service
public class CSkuServiceImpl extends CrudServiceImpl<CSkuDao, CSkuEntity, CSkuDTO> implements CSkuService {

    @Autowired
    CSkuDao dao;

    @Override
    public QueryWrapper<CSkuEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<CSkuEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

    @Override
    public void saveMemberPrice(CCommodityMemberDTO dto) {
        dao.saveMemberPrice(dto);
    }

    @Override
    public List<CCommodityMemberDTO> getMemberInfo(Long commodityId) {
        return dao.getMemberInfo(commodityId);
    }

    @Override
    public void updateMemberInfo(CCommodityMemberDTO dto) {
        dao.updateMemberInfo(dto);
    }

    @Override
    public Long getCommodityIdById(Long id) {
        return dao.getCommodityIdById(id);
    }

    @Override
    public void deleteMemberInfo(Long commodityId) {
        dao.deleteMemberInfo(commodityId);
    }
}