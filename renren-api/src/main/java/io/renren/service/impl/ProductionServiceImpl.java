/**
 * FileName: ProductionServiceImpl
 * Author:   dinggc
 * Date:     2019/7/29 22:29
 * Description: 商品接口的实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package io.renren.service.impl;

import io.renren.dao.ProductionDao;
import io.renren.entity.*;
import io.renren.service.ProductionService;
import io.renren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈商品接口的实现类〉
 *
 * @author dinggc
 * @create 2019/7/29
 * @since 1.0.0
 */
@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductionDao productionDao;

    @Override
    public List<ObjectCommodity> getProductions(Long userId) {
        if(userId != null){
            //判断当前的用户是否代理了商品
            List<String> production = userService.getAgentProduction(userId);
        }
        return productionDao.getProductions(userId);
    }

    @Override
    public List<CommodityColor> getCommodityColor(String commodityId) {
        return productionDao.getCommodityColor(commodityId);
    }

    @Override
    public List<CommodityVersion> getCommodityVersion(String commodityId) {
        return productionDao.getCommodityVersion(commodityId);
    }

    @Override
    public void insertShoppingCar(ShoppingCar shoppingCar) {
        productionDao.insertShoppingCar(shoppingCar);
    }

    @Override
    public Map<String, Object> isExistCarProduction(String commodityId, String skuId, String colorId) {
        ShoppingCar production = productionDao.isExistCarProduction(commodityId, skuId, colorId);
        Map<String,Object> map = new HashMap<String, Object>();
        boolean flag  = true;
        if(production == null){
            flag = false;
        }else{
            map.put("skuNumber",production.getSkuNumber());
            map.put("totalPrice",production.getTotalPrice());
        }
        map.put("flag",flag);
        return map;
    }

    @Override
    public void updateCarProduction(ShoppingCar shoppingCar) {
        productionDao.updateCarProduction(shoppingCar);
    }

    @Override
    public List<ObjectShoppingCar> getShoppingCar(Long userId) {
        return productionDao.getShoppingCar(userId);
    }

    @Override
    public void deleteShoppingCar(String id) {
        productionDao.deleteShoppingCar(id);
    }

    @Override
    public void changeCarStatus(String id, String isChoose) {
        productionDao.changeCarStatus(id,isChoose);
    }

    @Override
    public void changeCarNumber(ShoppingCar shoppingCar) {
        productionDao.changeCarNumber(shoppingCar);
    }

    @Override
    public void deleteCarProductions(Long userId) {
        productionDao.deleteCarProductions(userId);
    }

    @Override
    public List<ObjectShoppingCar> getIsChooseShoppingCar(Long userId) {
        return productionDao.getIsChooseShoppingCar(userId);
    }

    @Override
    public void saveAddress(Address address) {
        productionDao.saveAddress(address);
    }

    @Override
    public Address isExistAddress(String id) {
        return productionDao.isExistAddress(id);
    }

    @Override
    public void updateAddress(Address address) {
        productionDao.updateAddress(address);
    }

    @Override
    public void updateState(String id, Long userId) {
        productionDao.updateState(id,userId);
    }

    @Override
    public Address getDefaultAddress(Long userId) {
        return productionDao.getDefaultAddress(userId);
    }

    @Override
    public List<Address> getAddress(Long userId) {
        return productionDao.getAddress(userId);
    }
}