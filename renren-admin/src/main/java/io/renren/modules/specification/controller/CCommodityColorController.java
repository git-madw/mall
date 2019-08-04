package io.renren.modules.specification.controller;

import com.alibaba.fastjson.JSONArray;
import io.renren.common.annotation.LogOperation;
import io.renren.common.constant.Constant;
import io.renren.common.page.PageData;
import io.renren.common.utils.ExcelUtils;
import io.renren.common.utils.Result;
import io.renren.common.validator.AssertUtils;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DefaultGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.production.dto.CommodityDTO;
import io.renren.modules.specification.dto.CCommodityColorDTO;
import io.renren.modules.specification.excel.CCommodityColorExcel;
import io.renren.modules.specification.service.CCommodityColorService;
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
 * @since 1.0.0 2019-08-03
 */
@RestController
@RequestMapping("demo/ccommoditycolor")
@Api(tags="")
public class CCommodityColorController {
    @Autowired
    private CCommodityColorService cCommodityColorService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    @RequiresPermissions("production:specification:page")
    public Result<PageData<CCommodityColorDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<CCommodityColorDTO> page = cCommodityColorService.page(params);

        return new Result<PageData<CCommodityColorDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("production:specification:info")
    public Result<CCommodityColorDTO> get(@PathVariable("id") Long id){
        CCommodityColorDTO data = cCommodityColorService.get(id);

        return new Result<CCommodityColorDTO>().ok(data);
    }

    @PostMapping("getCommoditySpecification")
    @ApiOperation("根据商品id获取规格")
    @RequiresPermissions("production:specification:info")
    public Result<List<CCommodityColorDTO>> getCommoditySpecification(HttpServletRequest request){
        Long id = Long.parseLong(request.getParameter("id"));
        List<CCommodityColorDTO> specification = cCommodityColorService.getCommoditySpecification(id);
        return new Result<List<CCommodityColorDTO>>().ok(specification);
    }

    @PostMapping("getSpecification")
    @ApiOperation("获取所有未绑定的商品的规格")
    @RequiresPermissions("production:specification:save")
    public Result<List<CCommodityColorDTO>> getSpecification(){
        List<CCommodityColorDTO> specification = cCommodityColorService.getSpecification();
        return new Result<List<CCommodityColorDTO>>().ok(specification);
    }
    /**
     * 功能描述: <br>
     * 〈获取未绑定的商品规格〉
     * @Param: [dto]
     * @Return: io.renren.common.utils.Result
     * @Author: dinggc
     * @Date: 2019/8/4 15:04
     */
    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("production:specification:save")
    public Result save(@RequestBody CCommodityColorDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        dto.setDate(new Date());
        cCommodityColorService.save(dto);

        return new Result();
    }
    /**
     * 功能描述: <br>
     * 〈保存商品的规格信息〉
     * @Param: [request]
     * @Return: io.renren.common.utils.Result
     * @Author: dinggc
     * @Date: 2019/8/4 15:29
     */
    @PostMapping("saveCommodityColor")
    @ApiOperation("保存规格信息")
    @RequiresPermissions("production:specification:save")
    public Result saveCommodityColor(@RequestBody List<CCommodityColorDTO> dtos){
        for(CCommodityColorDTO dto : dtos){
            cCommodityColorService.updateCommodityColor(dto.getCommodityid(),dto.getId());
        }
        return new Result();
    }

    @PostMapping("deleteSpec")
    @ApiOperation("删除商品规格")
    @RequiresPermissions("production:specification:delete")
    public Result deleteSpec(HttpServletRequest request){
        Long id = Long.parseLong(request.getParameter("id"));
        cCommodityColorService.deleteSpec(id);
        return new Result();
    }

    @PostMapping("getProductionSpecification")
    @ApiOperation("获取当前商品的规格")
    @RequiresPermissions("production:specification:info")
    public Result<List<CCommodityColorDTO>> getProductionSpecification(HttpServletRequest request){
        Long id = Long.parseLong(request.getParameter("id"));
        List<CCommodityColorDTO> specification = cCommodityColorService.getProductionSpecification(id);
        return new Result<List<CCommodityColorDTO>>().ok(specification);
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("production:specification:update")
    public Result update(@RequestBody CCommodityColorDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        cCommodityColorService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("production:specification:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        cCommodityColorService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("production:specification:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<CCommodityColorDTO> list = cCommodityColorService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, CCommodityColorExcel.class);
    }

}