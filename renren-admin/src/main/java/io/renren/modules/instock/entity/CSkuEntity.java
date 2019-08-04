package io.renren.modules.instock.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * sku库存表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-04
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("c_sku")
public class CSkuEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 编号
	 */
	private Long id;
    /**
     * 商品id
     */
	private Long commodityid;
    /**
     * 库存
     */
	private Integer instock;
    /**
     * 价格
     */
	private BigDecimal price;
    /**
     * 创建时间
     */
	private Date date;
    /**
     * sku名称
     */
	private String skuname;
    /**
     * sku销量
     */
	private Integer skusalesvolume;
    /**
     * 库存地址
     */
	private String instockaddress;
}