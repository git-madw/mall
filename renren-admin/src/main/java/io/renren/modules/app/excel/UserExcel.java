package io.renren.modules.app.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 用户
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-06
 */
@Data
public class UserExcel {
    @Excel(name = "id")
    private Long id;
    @Excel(name = "用户名")
    private String username;
    @Excel(name = "手机号")
    private String mobile;
    @Excel(name = "密码")
    private String password;
    @Excel(name = "创建时间")
    private Date createDate;

}