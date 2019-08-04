package io.renren.modules.specification.dto;

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
 * @since 1.0.0 2019-08-03
 */
@Data
@ApiModel(value = "")
public class CCommodityColorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "编号")
	private Long id;

	@ApiModelProperty(value = "商品id")
	private Long commodityid;

	@ApiModelProperty(value = "商品颜色")
	private String commoditycolor;

	@ApiModelProperty(value = "是否启用")
	private Integer isuse;

	@ApiModelProperty(value = "创建时间")
	private Date date;

	@ApiModelProperty(value = "款式图片链接")
	private String url;

}