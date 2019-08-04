package io.renren.modules.specification.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.specification.dao.CCommodityColorDao;
import io.renren.modules.specification.dto.CCommodityColorDTO;
import io.renren.modules.specification.entity.CCommodityColorEntity;
import io.renren.modules.specification.service.CCommodityColorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-03
 */
@Service
public class CCommodityColorServiceImpl extends CrudServiceImpl<CCommodityColorDao, CCommodityColorEntity, CCommodityColorDTO> implements CCommodityColorService {

    @Autowired
    CCommodityColorDao dao;

    @Override
    public QueryWrapper<CCommodityColorEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<CCommodityColorEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


    @Override
    public List<CCommodityColorDTO> getSpecification() {
        return dao.getSpecification();
    }

    @Override
    public void updateCommodityColor(Long commodityId,Long id) {
        dao.updateCommodityColor(commodityId,id);
    }

    @Override
    public List<CCommodityColorDTO> getProductionSpecification(Long id) {
        return dao.getProductionSpecification(id);
    }

    @Override
    public void deleteSpec(Long id) {
        dao.deleteSpec(id);
    }

    @Override
    public List<CCommodityColorDTO> getCommoditySpecification(Long commodityId) {
        return dao.getCommoditySpecification(commodityId);
    }
}