/**
 * Copyright (C), 2015-2019
 * FileName: ObjectSpikeSku
 * Author:   A
 * Date:     2019/3/25 12:02
 * Description: 秒杀sku扩展类
 */
package io.renren.entity;

import java.util.Date;

/**
 * 〈秒杀sku扩展类〉
 * @author A
 * @create 2019/3/25
 * @since 1.0.0
 */
public class ObjectSpikeSku extends Sku{
    private String color;
    private String version;
    private Date spikeDate;

    public Date getSpikeDate() {
        return spikeDate;
    }

    public void setSpikeDate(Date spikeDate) {
        this.spikeDate = spikeDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
