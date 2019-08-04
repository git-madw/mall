package io.renren.modules.production.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.common.utils.SnowFlake;
import io.renren.modules.production.dao.CommodityDao;
import io.renren.modules.production.dto.CCommodityLbDTO;
import io.renren.modules.production.dto.CommodityDTO;
import io.renren.modules.production.entity.CCommodityLbEntity;
import io.renren.modules.production.entity.CommodityEntity;
import io.renren.modules.production.service.CommodityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商品表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-02
 */
@Service
public class CommodityServiceImpl extends CrudServiceImpl<CommodityDao, CommodityEntity, CommodityDTO> implements CommodityService {

    @Autowired
    CommodityDao commodityDao;

    @Override
    public QueryWrapper<CommodityEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<CommodityEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


    @Override
    public void saveLbPicture(List<CCommodityLbDTO> dtos, Long commodityId) {
        for(CCommodityLbDTO dto:dtos){
            if(dto.getId() != null){
                this.updateLb(dto);
            }else{
                CCommodityLbEntity entity = new CCommodityLbEntity();
                SnowFlake snowFlake = new SnowFlake();
                entity.setId(snowFlake.nextId());
                entity.setCommodityid(commodityId);
                entity.setUrl(dto.getUrl());
                entity.setCreateDate(new Date());
                commodityDao.saveLbPicture(entity);
            }
        }
    }

    @Override
    public List<CCommodityLbDTO> getLbCommodity(Long id) {
        return commodityDao.getLbCommodity(id);
    }

    @Override
    public void deleteLb(Long id) {
        commodityDao.deleteLb(id);
    }

    @Override
    public void updateLb(CCommodityLbDTO dto) {
        commodityDao.updateLb(dto);
    }

    @Override
    public List<CommodityDTO> queryCommodity(String key) {
        return commodityDao.queryCommodity(key);
    }

}