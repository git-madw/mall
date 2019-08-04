package io.renren.modules.specification.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-03
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("c_commodity_color")
public class CCommodityColorEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private Long id;
    /**
     * 商品id
     */
	private Long commodityid;
    /**
     * 商品颜色
     */
	private String commoditycolor;
    /**
     * 是否启用
     */
	private Integer isuse;
    /**
     * 创建时间
     */
	private Date date;
    /**
     * 款式图片链接
     */
	private String url;
}