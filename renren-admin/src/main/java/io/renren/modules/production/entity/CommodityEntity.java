package io.renren.modules.production.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 商品表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-02
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("commodity")
public class CommodityEntity{
	private static final long serialVersionUID = 1L;
	/**
	 * 编号
	 */
	private Long id;
    /**
     * 商品名称
     */
	private String commodityname;
    /**
     * 商品图片
     */
	private String commoditypicture;
    /**
     * 分类编号1
     */
	private String classificationfirstid;
    /**
     * 分类编号2
     */
	private String classificationsecondid;
    /**
     * 品牌id
     */
	private String brandid;
    /**
     * 创建时间
     */
	private Date date;
    /**
     * 商品描述
     */
	private String description;
}