package io.renren.modules.production.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 商品表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-02
 */
@Data
@ApiModel(value = "商品表")
public class CommodityDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "编号")
	private Long id;

	@ApiModelProperty(value = "商品名称")
	private String commodityname;

	@ApiModelProperty(value = "商品图片")
	private String commoditypicture;

	@ApiModelProperty(value = "分类编号1")
	private String classificationfirstid;

	@ApiModelProperty(value = "分类编号2")
	private String classificationsecondid;

	@ApiModelProperty(value = "品牌id")
	private String brandid;

	@ApiModelProperty(value = "创建时间")
	private Date date;

	@ApiModelProperty(value = "商品描述")
	private String description;


}