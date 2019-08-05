package io.renren.modules.instock.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-05
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("c_commodity_member")
public class CCommodityMemberEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 会员等级
     */
	private Long memberid;
    /**
     * 商品id
     */
	private Long commodityid;
    /**
     * 购买数量
     */
	private Integer number;
    /**
     * 价格
     */
	private BigDecimal price;
}