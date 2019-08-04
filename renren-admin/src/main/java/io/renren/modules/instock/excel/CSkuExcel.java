package io.renren.modules.instock.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * sku库存表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-04
 */
@Data
public class CSkuExcel {
    @Excel(name = "编号")
    private String id;
    @Excel(name = "商品id")
    private String commodityid;
    @Excel(name = "库存")
    private Integer instock;
    @Excel(name = "价格")
    private BigDecimal price;
    @Excel(name = "创建时间")
    private Date date;
    @Excel(name = "sku名称")
    private String skuname;
    @Excel(name = "sku销量")
    private Integer skusalesvolume;
    @Excel(name = "库存地址")
    private String instockaddress;

}