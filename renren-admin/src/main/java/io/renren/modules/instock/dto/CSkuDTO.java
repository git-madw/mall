package io.renren.modules.instock.dto;

import io.renren.modules.specification.dto.CCommodityColorDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;
import java.util.List;

/**
 * sku库存表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-04
 */
@Data
@ApiModel(value = "sku库存表")
public class CSkuDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "编号")
	private Long id;

	@ApiModelProperty(value = "商品id")
	private Long commodityid;

	@ApiModelProperty(value = "库存")
	private Integer instock;

	@ApiModelProperty(value = "价格")
	private BigDecimal price;

	@ApiModelProperty(value = "创建时间")
	private Date date;

	@ApiModelProperty(value = "sku名称")
	private String skuname;

	@ApiModelProperty(value = "sku销量")
	private Integer skusalesvolume;

	@ApiModelProperty(value = "库存地址")
	private String instockaddress;

	private List<CSkuColorPriceDTO> dto;
}