package io.renren.modules.instock.controller;

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
import io.renren.modules.instock.dto.CCommodityMemberDTO;
import io.renren.modules.instock.dto.CSkuDTO;
import io.renren.modules.instock.excel.CSkuExcel;
import io.renren.modules.instock.service.CSkuService;
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
 * sku库存表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-04
 */
@RestController
@RequestMapping("demo/csku")
@Api(tags="sku库存表")
public class CSkuController {
    @Autowired
    private CSkuService cSkuService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    @RequiresPermissions("instock:sku:page")
    public Result<PageData<CSkuDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<CSkuDTO> page = cSkuService.page(params);

        return new Result<PageData<CSkuDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("instock:sku:info")
    public Result<CSkuDTO> get(@PathVariable("id") Long id){
        CSkuDTO data = cSkuService.get(id);
        return new Result<CSkuDTO>().ok(data);
    }

    @PostMapping("getMemberInfo")
    @ApiOperation("获取当前库存的会员等级的数量和价格")
    @RequiresPermissions("instock:sku:info")
    public Result<List<CCommodityMemberDTO>> getMemberInfo(HttpServletRequest request){
        Long id = Long.parseLong(request.getParameter("id"));
        List<CCommodityMemberDTO> info = cSkuService.getMemberInfo(id);
        return new Result<List<CCommodityMemberDTO>>().ok(info);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("instock:sku:save")
    public Result save(@RequestBody CSkuDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        dto.setDate(new Date());
        cSkuService.save(dto);
        List<CCommodityMemberDTO> dtos = dto.getDtos();
        for(CCommodityMemberDTO memberDTO : dtos){
            SnowFlake snowFlake = new SnowFlake();
            memberDTO.setId(snowFlake.nextId());
            memberDTO.setCreateDate(new Date());
            cSkuService.saveMemberPrice(memberDTO);
        }
        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("instock:sku:update")
    public Result update(@RequestBody CSkuDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        cSkuService.update(dto);
        List<CCommodityMemberDTO> dtos = dto.getDtos();
        for(CCommodityMemberDTO memberDTO : dtos){
            cSkuService.updateMemberInfo(memberDTO);
        }
        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("instock:sku:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        cSkuService.delete(ids);
        for(int i=0;i<ids.length;i++){
            Long commodityId = cSkuService.getCommodityIdById(ids[i]);
            cSkuService.deleteMemberInfo(commodityId);
        }

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("instock:sku:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<CSkuDTO> list = cSkuService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, CSkuExcel.class);
    }

}