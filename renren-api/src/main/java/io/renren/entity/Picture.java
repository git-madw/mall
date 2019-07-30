package io.renren.entity;

/**
 * @program: shop
 * @description: 图片bean
 * @author: dinggc
 * @create: 2019-03-09 11:26
 **/
public class Picture extends BaseEntity{
    private String effect;
    private String typeId;
    private String url;

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
