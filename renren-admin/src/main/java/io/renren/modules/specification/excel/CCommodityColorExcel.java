package io.renren.modules.specification.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-03
 */
@Data
public class CCommodityColorExcel {
    @Excel(name = "编号")
    private Long id;
    @Excel(name = "商品id")
    private Long commodityid;
    @Excel(name = "商品颜色")
    private String commoditycolor;
    @Excel(name = "是否启用")
    private Integer isuse;
    @Excel(name = "创建时间")
    private Date date;
    @Excel(name = "款式图片链接")
    private String url;

}