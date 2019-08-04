package io.renren.modules.classification.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 分类1表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-04
 */
@Data
public class CClassificationFirstExcel {
    @Excel(name = "编号")
    private Long id;
    @Excel(name = "分类名称")
    private String classificationfirst;
    @Excel(name = "创建人")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createDate;

}