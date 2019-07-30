/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.dao;

import io.renren.common.dao.BaseDao;
import io.renren.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户
 * 
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {
    UserEntity getUserByMobile(String mobile);

    UserEntity getUserByUserId(Long userId);

    /**
     * 保存代理和授权商品信息
     */
    void authorizationProduction(@Param("agentId") Long id, @Param("userId") Long userId);

    /**
     * 保存代理
     */
    void insertAgent(@Param("agentId") Long agentId,@Param("userId") Long userId);

    /***
     * 获取代理的商品的信息
     * @return
     */
    List<String> getAgentProduction(@Param("agentId") Long agentId);

    /***
     * 保存商品信息
     */
    void insertProductionList(@Param("list") List<String> list,@Param("userId") Long userId);
}
