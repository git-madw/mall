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
    private String id;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BaseEntity(String id) {
        this.id = id;
    }
    public BaseEntity() {
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString().replace("-", "");
    }

}
