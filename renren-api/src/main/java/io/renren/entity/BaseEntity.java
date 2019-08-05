package io.renren.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
* @Description: 公共属性提取基本类
* @Param:
* @return:
* @Author: dinggc
* @Date: 2019/2/19
*/
public class BaseEntity implements Serializable {
    /**
    * 主键id
    */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
