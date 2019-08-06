package io.renren.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.service.impl.CrudServiceImpl;
import io.renren.modules.app.dao.UserDao;
import io.renren.modules.app.dto.UserDTO;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.app.service.UserService;
import io.renren.modules.production.dto.CommodityDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-06
 */
@Service
public class UserServiceImpl extends CrudServiceImpl<UserDao, UserEntity, UserDTO> implements UserService {

    @Autowired
    UserDao dao;

    @Override
    public QueryWrapper<UserEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


    @Override
    public List<UserDTO> getUpAgentUser(Long agentId) {
        return dao.getUpAgentUser(agentId);
    }

    @Override
    public List<UserDTO> getDownAgentUser(Long userId) {
        return dao.getDownAgentUser(userId);
    }

    @Override
    public List<CommodityDTO> getCommodityAgentUser(Long userId) {
        return dao.getCommodityAgentUser(userId);
    }
}