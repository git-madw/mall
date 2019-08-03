package io.renren.modules.production.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.production.dao.CommodityDao;
import io.renren.modules.production.dto.CommodityDTO;
import io.renren.modules.production.entity.CommodityEntity;
import io.renren.modules.production.service.CommodityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 商品表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-02
 */
@Service
public class CommodityServiceImpl extends CrudServiceImpl<CommodityDao, CommodityEntity, CommodityDTO> implements CommodityService {

    @Override
    public QueryWrapper<CommodityEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<CommodityEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}