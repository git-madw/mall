package io.renren.modules.classification.controller;

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
import io.renren.modules.classification.dto.CClassificationFirstDTO;
import io.renren.modules.classification.excel.CClassificationFirstExcel;
import io.renren.modules.classification.service.CClassificationFirstService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 分类1表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-04
 */
@RestController
@RequestMapping("demo/cclassificationfirst")
@Api(tags="分类1表")
public class CClassificationFirstController {
    @Autowired
    private CClassificationFirstService cClassificationFirstService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    @RequiresPermissions("production:classification:page")
    public Result<PageData<CClassificationFirstDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<CClassificationFirstDTO> page = cClassificationFirstService.page(params);

        return new Result<PageData<CClassificationFirstDTO>>().ok(page);
    }
    /**
     * 功能描述: <br>
     * 〈获取所有的商品的分类〉
     * @Param: []
     * @Return: io.renren.common.utils.Result<java.util.List<io.renren.modules.classification.dto.CClassificationFirstDTO>>
     * @Author: dinggc
     * @Date: 2019/8/4 12:05
     */
    @PostMapping("getClassification")
    @ApiOperation("获取分类")
    @RequiresPermissions("production:commodity:info")
    public Result<List<CClassificationFirstDTO>> getClassification(){
        List<CClassificationFirstDTO> classification = cClassificationFirstService.getClassification();
        return new Result<List<CClassificationFirstDTO>>().ok(classification);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("production:classification:info")
    public Result<CClassificationFirstDTO> get(@PathVariable("id") Long id){
        CClassificationFirstDTO data = cClassificationFirstService.get(id);

        return new Result<CClassificationFirstDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("production:classification:save")
    public Result save(@RequestBody CClassificationFirstDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        dto.setCreateDate(new Date());
        cClassificationFirstService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("production:classification:update")
    public Result update(@RequestBody CClassificationFirstDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        cClassificationFirstService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("production:classification:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        cClassificationFirstService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("production:classification:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<CClassificationFirstDTO> list = cClassificationFirstService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, CClassificationFirstExcel.class);
    }

}