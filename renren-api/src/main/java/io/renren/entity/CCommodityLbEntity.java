package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-03
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("c_commodity_lb")
public class CCommodityLbEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
	private Long commodityid;
    /**
     * 路径
     */
	private String url;
}