package io.renren.modules.instock.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.instock.entity.CSkuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * sku库存表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-04
 */
@Mapper
public interface CSkuDao extends BaseDao<CSkuEntity> {
}