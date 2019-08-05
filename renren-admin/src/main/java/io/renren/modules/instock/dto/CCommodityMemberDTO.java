package io.renren.modules.instock.dto;

import io.renren.modules.sys.dto.UserMemberDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-05
 */
@Data
@ApiModel(value = "")
public class CCommodityMemberDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "编号")
	private Long id;

	@ApiModelProperty(value = "会员等级")
	private Long memberid;

	@ApiModelProperty(value = "商品id")
	private Long commodityid;

	@ApiModelProperty(value = "购买数量")
	private Integer number;

	@ApiModelProperty(value = "价格")
	private BigDecimal price;

	@ApiModelProperty(value = "创建人")
	private Long creator;

	@ApiModelProperty(value = "创建时间")
	private Date createDate;

	private String grade;

}