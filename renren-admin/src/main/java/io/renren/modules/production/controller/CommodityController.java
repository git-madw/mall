package io.renren.modules.production.controller;

import io.renren.common.annotation.LogOperation;
import io.renren.common.constant.Constant;
import io.renren.common.exception.ErrorCode;
import io.renren.common.page.PageData;
import io.renren.common.utils.ExcelUtils;
import io.renren.common.utils.Result;
import io.renren.common.utils.UploadUtils;
import io.renren.common.validator.AssertUtils;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.DefaultGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.oss.cloud.OSSFactory;
import io.renren.modules.oss.entity.SysOssEntity;
import io.renren.modules.production.dto.CCommodityLbDTO;
import io.renren.modules.production.dto.CommodityDTO;
import io.renren.modules.production.entity.CCommodityLbEntity;
import io.renren.modules.production.excel.CommodityExcel;
import io.renren.modules.production.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 商品表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-02
 */
@RestController
@RequestMapping("demo/commodity")
@Api(tags="商品表")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    @RequiresPermissions("production:commodity:page")
    public Result<PageData<CommodityDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<CommodityDTO> page = commodityService.page(params);

        return new Result<PageData<CommodityDTO>>().ok(page);
    }

    @PostMapping("getCommodityList")
    @ApiOperation("模糊查询商品列表")
    @RequiresPermissions("production:commodity:page")
    public Result<List<CommodityDTO>> getCommodityList(HttpServletRequest request){
        String key = request.getParameter("key");
        List<CommodityDTO> dtos = commodityService.queryCommodity(key);
        return new Result<List<CommodityDTO>>().ok(dtos);
    }

    @PostMapping("getCommodity")
    @ApiOperation("根据id获取商品信息")
    @RequiresPermissions("production:commodity:info")
    public Result<CommodityDTO> getCommodity(HttpServletRequest request){
        Long id = Long.parseLong(request.getParameter("id"));
        CommodityDTO data = commodityService.get(id);
        List<CCommodityLbDTO> commodity = commodityService.getLbCommodity(id);
        data.setDtos(commodity);
        return new Result<CommodityDTO>().ok(data);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("production:commodity:info")
    public Result<CommodityDTO> get(@PathVariable("id") Long id){
        CommodityDTO data = commodityService.get(id);
        List<CCommodityLbDTO> commodity = commodityService.getLbCommodity(id);
        data.setDtos(commodity);
        return new Result<CommodityDTO>().ok(data);
    }

    @PostMapping("deleteLb")
    @ApiOperation("删除商品轮播图")
    @RequiresPermissions("production:commodity:delete")
    public Object deleteLb(HttpServletRequest request){
        String id = request.getParameter("id");
        commodityService.deleteLb(Long.parseLong(id));
        return new Result().success();
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("production:commodity:save")
    public Result save(@RequestBody CommodityDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);
        dto.setDate(new Date());
        commodityService.save(dto);
        commodityService.saveLbPicture(dto.getDtos(),dto.getId());
        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("production:commodity:update")
    public Result update(@RequestBody CommodityDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);
        commodityService.saveLbPicture(dto.getDtos(),dto.getId());
        commodityService.update(dto);
        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("production:commodity:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        commodityService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("production:commodity:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        List<CommodityDTO> list = commodityService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, CommodityExcel.class);
    }

    /**
     * 图片上传
     * @return
     */
    @RequestMapping(value = "uploadImages")
    @ResponseBody
    @RequiresPermissions("production:commodity:save")
    public Result<Map<String, Object>> uploadImages(@RequestParam("img") MultipartFile file, HttpServletRequest request) throws Exception {
        Map<String, Object> map = UploadUtils.ImgUpload(file);
        return new Result<Map<String, Object>>().ok(map);
    }
}