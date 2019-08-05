package io.renren.modules.sys.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-05
 */
@Data
public class UserMemberExcel {
    @Excel(name = "编号")
    private Long id;
    @Excel(name = "会员等级")
    private String grade;
    @Excel(name = "等级描述")
    private String description;
    @Excel(name = "创建人")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createDate;

}