package io.renren.modules.app.service;

import io.renren.common.service.CrudService;
import io.renren.modules.app.dto.UserDTO;
import io.renren.modules.app.entity.UserEntity;
import io.renren.modules.production.dto.CommodityDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-06
 */
public interface UserService extends CrudService<UserEntity, UserDTO> {
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
    List<UserDTO> getDownAgentUser(Long userId);
    /**
     * 获取当前用户的代理商品
     * @param userId
     * @return
     */
    List<CommodityDTO> getCommodityAgentUser(Long userId);
}