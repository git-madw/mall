/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.service;

import io.renren.common.service.BaseService;
import io.renren.entity.UserEntity;
import io.renren.dto.LoginDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户
 * 
 * @author Mark sunlightcs@gmail.com
 */
public interface UserService extends BaseService<UserEntity> {

	UserEntity getByMobile(String mobile);

	UserEntity getUserByUserId(Long userId);

	/**
	 * 用户登录
	 * @param dto    登录表单
	 * @return        返回登录信息
	 */
	Map<String, Object> login(LoginDTO dto);
	/**
	 * 保存代理和授权商品信息
	 */
	void authorizationProduction(Long agentId,Long userId);

	/**
	 * 保存代理
	 */
	void insertAgent(Long agentId,Long userId);
	/***
	 * 获取代理的商品的信息
	 * @return
	 */
	List<String> getAgentProduction(Long agentId);

	/***
	 * 保存商品信息
	 */
	void insertProductionList(List<String> list,Long userId);
}
