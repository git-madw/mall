package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 用户
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-06
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("tb_user")
public class UserEntity{
	private static final long serialVersionUID = 1L;
	/**
	 * 编号
	 */
	private Long id;
    /**
     * 用户名
     */
	private String username;
    /**
     * 手机号
     */
	private String mobile;
    /**
     * 密码
     */
	private String password;
	/**
	 * 时间
	 */
	private Date createDate;
}