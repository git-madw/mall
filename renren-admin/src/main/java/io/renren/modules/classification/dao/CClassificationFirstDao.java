package io.renren.modules.classification.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.classification.dto.CClassificationFirstDTO;
import io.renren.modules.classification.entity.CClassificationFirstEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 分类1表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-04
 */
@Mapper
public interface CClassificationFirstDao extends BaseDao<CClassificationFirstEntity> {
    /**
     * 功能描述: <br>
     * 〈获取商品的所有的分类〉
     * @Param: []
     * @Return: java.util.List<io.renren.modules.classification.dto.CClassificationFirstDTO>
     * @Author: dinggc
     * @Date: 2019/8/4 12:01
     */
    List<CClassificationFirstDTO> getClassification();
}