package io.renren.modules.classification.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.classification.dao.CClassificationFirstDao;
import io.renren.modules.classification.dto.CClassificationFirstDTO;
import io.renren.modules.classification.entity.CClassificationFirstEntity;
import io.renren.modules.classification.service.CClassificationFirstService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 分类1表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-04
 */
@Service
public class CClassificationFirstServiceImpl extends CrudServiceImpl<CClassificationFirstDao, CClassificationFirstEntity, CClassificationFirstDTO> implements CClassificationFirstService {

    @Autowired
    CClassificationFirstDao dao;

    @Override
    public QueryWrapper<CClassificationFirstEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<CClassificationFirstEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


    @Override
    public List<CClassificationFirstDTO> getClassification() {
        return dao.getClassification();
    }
}