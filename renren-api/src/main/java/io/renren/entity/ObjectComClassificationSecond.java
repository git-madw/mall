package io.renren.entity;

/**
 * @program: shop
 * @description: 商品分类2的子类
 * @author: dinggc
 * @create: 2019-03-08 12:16
 **/
public class ObjectComClassificationSecond extends ComClassificationSecond{
    private ComClassificationFirst comClassificationFirst;

    public ComClassificationFirst getComClassificationFirst() {
        return comClassificationFirst;
    }

    public void setComClassificationFirst(ComClassificationFirst comClassificationFirst) {
        this.comClassificationFirst = comClassificationFirst;
    }
}
