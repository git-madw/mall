package io.renren.modules.sys.controller;

import io.renren.common.annotation.LogOperation;
import io.renren.common.constant.Constant;
import io.renren.common.page.PageData;
import io.renren.common.utils.ExcelUtils;
import io.renren.common.utils.Result;
import io.renren.common.utils.SnowFlake;
import io.renren.common.validator.AssertUtils;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DefaultGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.production.dto.CommodityDTO;
import io.renren.modules.sys.dto.UserMemberDTO;
import io.renren.modules.sys.excel.UserMemberExcel;
import io.renren.modules.sys.service.UserMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-05
 */
@RestController
@RequestMapping("demo/usermember")
@Api(tags="")
public class UserMemberController {
    @Autowired
    private UserMemberService userMemberService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    @RequiresPermissions("sys:member:page")
    public Result<PageData<UserMemberDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<UserMemberDTO> page = userMemberService.page(params);

        return new Result<PageData<UserMemberDTO>>().ok(page);
    }

    @PostMapping("getMembers")
    @ApiOperation("获取所有的会员信息")
    @RequiresPermissions("sys:member:info")
    public Result<List<UserMemberDTO>> getMembers(){
        List<UserMemberDTO> members = userMemberService.getMembers();
        return new Result<List<UserMemberDTO>>().ok(members);
    }

    @PostMapping("saveMember")
    @ApiOperation("保存商品的会员等级信息")
    @RequiresPermissions("sys:member:save")
    public Result saveMember(@RequestBody List<CommodityDTO> dtos){
        for(CommodityDTO dto:dtos){
            SnowFlake snowFlake = new SnowFlake();
            List<UserMemberDTO> members = dto.getMembers();
            userMemberService.saveMember(snowFlake.nextId(),dto.getId(),members.get(0).getId(),new Date());
        }
        return new Result();
    }

    @PostMapping("getProductionMember")
    @ApiOperation("获取商品的会员信息")
    @RequiresPermissions("sys:member:info")
    public Result<List<UserMemberDTO>> getProductionMember(HttpServletRequest request){
        Long id = Long.parseLong(request.getParameter("id"));
        List<UserMemberDTO> member = userMemberService.getProductionMember(id);
        return new Result<List<UserMemberDTO>>().ok(member);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("sys:member:info")
    public Result<UserMemberDTO> get(@PathVariable("id") Long id){
        UserMemberDTO data = userMemberService.get(id);

        return new Result<UserMemberDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("sys:member:save")
    public Result save(@RequestBody UserMemberDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        userMemberService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("sys:member:update")
    public Result update(@RequestBody UserMemberDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        userMemberService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("sys:member:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        userMemberService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("sys:member:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<UserMemberDTO> list = userMemberService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, UserMemberExcel.class);
    }

}