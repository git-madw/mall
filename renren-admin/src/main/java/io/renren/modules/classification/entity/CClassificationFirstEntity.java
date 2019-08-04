package io.renren.modules.classification.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 分类1表
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2019-08-04
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("c_classification_first")
public class CClassificationFirstEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

    /**
     * 分类名称
     */
	private String classificationfirst;
}