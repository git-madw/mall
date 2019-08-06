/**
 * FileName: ProductionService
 * Author:   dinggc
 * Date:     2019/7/29 22:29
 * Description: 商品的操作接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package io.renren.service;

import io.renren.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈商品的操作接口〉
 *
 * @author dinggc
 * @create 2019/7/29
 * @since 1.0.0
 */
public interface ProductionService {
    /***
     * 获取所有的商品信息
     * @param userId
     * @return
     */
    List<ObjectCommodity> getProductions(Long userId);
    /**
     * 功能描述: <br>
     * 〈获取商品的颜色〉
     * @Param: [commodityId]
     * @Return: io.renren.entity.ObjectCommodityInfo
     * @Author: dinggc
     * @Date: 2019/7/30 20:58
     */
    List<CommodityColor> getCommodityColor(Long commodityId);
    /**
     * 功能描述: <br>
     * 〈获取商品的版本〉
     * @Param: [commodityId]
     * @Return: io.renren.entity.ObjectCommodityInfo
     * @Author: dinggc
     * @Date: 2019/7/30 20:58
     */
    List<CommodityVersion> getCommodityVersion(Long commodityId);
    /**
     * 商品存入购物车
     */
    void insertShoppingCar(ShoppingCar shoppingCar);
    /**
     * 判断商品是否在购物车中已经存在
     */
    Map<String,Object> isExistCarProduction(Long commodityId,Long skuId,Long colorId);
    /**
     * 更新购物车商品信息
     */
    void updateCarProduction(ShoppingCar shoppingCar);
    /**
     * 用户获取购物车中的商品
     */
    List<ObjectShoppingCar> getShoppingCar(Long userId);
    /**
     * 根据id删除购物车商品
     */
    void deleteShoppingCar(Long id);
    /**
     * 更改商品选中状态
     */
    void changeCarStatus(Long id,String isChoose);
    /**
     * 更改商品选中数量
     */
    void changeCarNumber(ShoppingCar shoppingCar);
    /**
     * 删除用户购物车中的所有商品
     */
    void deleteCarProductions(Long userId);
    /**
     * 用户获取购物车中已经选中的商品生成订单
     */
    List<ObjectShoppingCar> getIsChooseShoppingCar(Long userId);
    /**
     * 保存或更新用户收获地址信息
     */
    void saveAddress(Address address);
    /**
     * 判断当前收获地址是否存在
     */
    Address isExistAddress(Long id);
    /**
     * 更新用户的收获地址
     */
    void updateAddress(Address address);
    /**
     * 更改收货地址的默认状态
     */
    void updateState(Long id,Long userId);
    /**
     * 获取用户的默认的收获地址
     */
    Address getDefaultAddress(Long userId);
    /**
     * 获取用户的所有的收获地址
     */
    List<Address> getAddress(Long userId);
    /**
     * 根据商品id获取商品的相关信息
     * @param commodityId
     * @return
     */
    ObjectCommodity getProductionsById(@Param("commodityId") Long commodityId);

}
