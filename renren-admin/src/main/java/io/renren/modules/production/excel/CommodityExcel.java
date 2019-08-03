package io.renren.modules.production.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 商品表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-02
 */
@Data
public class CommodityExcel {
    @Excel(name = "编号")
    private String id;
    @Excel(name = "商品名称")
    private String commodityname;
    @Excel(name = "商品图片")
    private String commoditypicture;
    @Excel(name = "分类编号1")
    private String classificationfirstid;
    @Excel(name = "分类编号2")
    private String classificationsecondid;
    @Excel(name = "品牌id")
    private String brandid;
    @Excel(name = "创建时间")
    private Date date;
    @Excel(name = "商品描述")
    private String description;

}