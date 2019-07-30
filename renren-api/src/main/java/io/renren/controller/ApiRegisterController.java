/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.controller;

import io.renren.common.utils.Result;
import io.renren.common.validator.ValidatorUtils;
import io.renren.entity.UserEntity;
import io.renren.dto.RegisterDTO;
import io.renren.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 注册接口
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/api")
@Api(tags="注册接口")
public class ApiRegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    @ApiOperation("注册")
    public Result register(@RequestBody RegisterDTO dto){
        //表单校验
        ValidatorUtils.validateEntity(dto);
        //获取invitation，判断APP注册用户是否为扫码注册
        UserEntity user = new UserEntity();
        user.setMobile(dto.getMobile());
        user.setUsername(dto.getUsername());
        user.setPassword(DigestUtils.sha256Hex(dto.getPassword()));
        user.setCreateDate(new Date());
        userService.insert(user);
        if(dto.getInvitation() != null && dto.getInvitation() != ""){
            //证明前台用户注册为提货商扫码注册
            //保存代理关系和获取上级代理的商品授权
            userService.authorizationProduction(Long.parseLong(dto.getInvitation()),user.getId());
        }
        //普通用户，注册用户完成
        return new Result();
    }
    /***
     * 商品授权
     * @param request
     * @return
     */
    @RequestMapping(value = "authorizationProduction")
    @ResponseBody
    public Object authorizationProduction(HttpServletRequest request){
        String agentId = request.getParameter("id");
        String userId = request.getParameter("userId");
        try {
            userService.authorizationProduction(Long.parseLong(agentId),Long.parseLong(userId));
            return new Result().success();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Result().error("授权失败");
    }
}