package io.renren.modules.app.dao;

import io.renren.common.dao.BaseDao;
import io.renren.modules.app.dto.UserDTO;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.production.dto.CommodityDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-06
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {
    /**
     * 获取当前用户的所有上级代理
     * @param agentId
     * @return
     */
    List<UserDTO> getUpAgentUser(@Param("agentId") Long agentId);

    /**
     * 获取当前用户的所有下级代理
     * @param userId
     * @return
     */
    List<UserDTO> getDownAgentUser(@Param("userId") Long userId);

    /**
     * 获取当前用户的代理商品
     * @param userId
     * @return
     */
    List<CommodityDTO> getCommodityAgentUser(@Param("userId") Long userId);
}