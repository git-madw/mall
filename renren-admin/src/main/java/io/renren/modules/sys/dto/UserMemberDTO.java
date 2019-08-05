package io.renren.modules.sys.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-05
 */
@Data
@ApiModel(value = "")
public class UserMemberDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "编号")
	private Long id;

	@ApiModelProperty(value = "会员等级")
	private String grade;

	@ApiModelProperty(value = "等级描述")
	private String description;

	@ApiModelProperty(value = "创建人")
	private Long creator;

	@ApiModelProperty(value = "创建时间")
	private Date createDate;


}