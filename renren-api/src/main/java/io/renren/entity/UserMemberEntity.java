package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-05
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("user_member")
public class UserMemberEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 会员等级
     */
	private String grade;
    /**
     * 等级描述
     */
	private String description;
}