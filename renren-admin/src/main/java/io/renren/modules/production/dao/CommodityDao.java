package io.renren.modules.production.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.production.entity.CommodityEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-02
 */
@Mapper
public interface CommodityDao extends BaseDao<CommodityEntity> {
	
}