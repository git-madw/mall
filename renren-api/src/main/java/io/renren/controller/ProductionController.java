/**
 * FileName: ProductionController
 * Author:   dinggc
 * Date:     2019/7/29 22:35
 * Description: 商品的controller类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.common.utils.Result;
import io.renren.dto.RegisterDTO;
import io.renren.entity.*;
import io.renren.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈商品的controller类〉
 *
 * @author dinggc
 * @create 2019/7/29
 * @since 1.0.0
 */
@Controller
@RequestMapping(value = "/api/production")
public class ProductionController {

    @Autowired
    ProductionService productionService;

    /**
     * 功能描述: <br>
     * 〈获取所有的商品信息〉
     * @Param: [request]
     * @Return: java.lang.Object
     * @Author: dinggc
     * @Date: 2019/7/29 22:40
     */
    @RequestMapping(value = "getProductions")
    @ResponseBody
    public Object getProductions(@RequestBody UserEntity userEntity){
        List<ObjectCommodity> productions = productionService.getProductions(userEntity.getId());
        if(productions.size() == 0){
            userEntity.setId(null);
            productions = productionService.getProductions(userEntity.getId());
        }
        for(ObjectCommodity commodity : productions){
            //commodity.setDescription(commodity.getDescription().replace("\"", "\'\\"));
            Long commodityId = commodity.getId();
            List<CommodityColor> commodityColor = productionService.getCommodityColor(commodityId);
            List<CommodityVersion> commodityVersion = productionService.getCommodityVersion(commodityId);
            ObjectCommodityInfo info = new ObjectCommodityInfo();
            info.setCommodityColors(commodityColor);
            info.setCommodityVersions(commodityVersion);
            commodity.setObjectCommodityInfo(info);
        }
        return new Result().ok(productions);
    }

    /**
     * 插入购物车商品信息
     * @param shoppingCar
     * @return
     */
    @Login
    @RequestMapping(value = "insertShoppingCar")
    @ResponseBody
    public Object insertShoppingCar(@RequestBody ShoppingCar shoppingCar){
        Map<String,Object> map = productionService.isExistCarProduction(shoppingCar.getCommodityId(),
                shoppingCar.getSkuId(),shoppingCar.getColor());
        if(Boolean.valueOf(String.valueOf(map.get("flag")))){
            BigDecimal price = BigDecimal.valueOf(Long.valueOf(shoppingCar.getSkuNumber())).multiply(shoppingCar.getSkuPrice());
            BigDecimal oldPrice = new BigDecimal(String.valueOf(map.get("totalPrice")));
            BigDecimal totalPrice = price.add(oldPrice);
            shoppingCar.setTotalPrice(totalPrice);
            int oldSkuNumber = Integer.valueOf(String.valueOf(map.get("skuNumber")));
            shoppingCar.setSkuNumber(shoppingCar.getSkuNumber()+oldSkuNumber);
            shoppingCar.setDate(new Date());
            productionService.updateCarProduction(shoppingCar);
        }else{
            shoppingCar.setDate(new Date());
            productionService.insertShoppingCar(shoppingCar);
        }
        return new Result().success();
    }
    /**
     * 用户获取购物车中的商品
     */
    @Login
    @RequestMapping(value = "getShoppingCar")
    @ResponseBody
    public Object getShoppingCar(@RequestBody UserEntity entity){
        List<ObjectShoppingCar> shoppingCar = productionService.getShoppingCar(entity.getId());
        return new Result().ok(shoppingCar);
    }

    /**
     * 根据id删除购物车商品
     * @param shoppingCar
     * @return
     */
    @Login
    @RequestMapping(value = "deleteShoppingCar")
    @ResponseBody
    public Object deleteShoppingCar(@RequestBody ShoppingCar shoppingCar){
        productionService.deleteShoppingCar(shoppingCar.getId());
        return new Result().success();
    }
    /**
     * 功能描述: <br>
     * 〈更改购物车商品选中状态〉
     * @Param: [shoppingCar]
     * @Return: java.lang.Object
     * @Author: dinggc
     * @Date: 2019/7/31 19:54
     */
    @Login
    @RequestMapping(value = "changeCarStatus")
    @ResponseBody
    public Object changeCarStatus(@RequestBody ShoppingCar shoppingCar){
        productionService.changeCarStatus(shoppingCar.getId(),shoppingCar.getIsChoose());
        return new Result().success();
    }
    /**
     * 功能描述: <br>
     * 〈更新用户购物车选中商品的数量〉
     * @Param: [shoppingCar]
     * @Return: java.lang.Object
     * @Author: dinggc
     * @Date: 2019/7/31 20:20
     */
    @Login
    @RequestMapping(value = "changeCarNumber")
    @ResponseBody
    public Object changeCarNumber(@RequestBody ShoppingCar shoppingCar){
        productionService.changeCarNumber(shoppingCar);
        return new Result().success();
    }
    /**
     * 功能描述: <br>
     * 〈删除用户购物车中的所有商品〉
     * @Param: [shoppingCar]
     * @Return: java.lang.Object
     * @Author: dinggc
     * @Date: 2019/7/31 20:30
     */
    @Login
    @RequestMapping(value = "deleteCarProductions")
    @ResponseBody
    public Object deleteCarProductions(@RequestBody ShoppingCar shoppingCar){
        productionService.deleteCarProductions(shoppingCar.getUserId());
        return new Result().success();
    }
    /**
     * 用户获取购物车中已经选中的商品生成订单
     */
    @Login
    @RequestMapping(value = "getIsChooseShoppingCar")
    @ResponseBody
    public Object getIsChooseShoppingCar(@RequestBody UserEntity entity){
        List<ObjectShoppingCar> shoppingCar = productionService.getIsChooseShoppingCar(entity.getId());
        return new Result().ok(shoppingCar);
    }

    /**
     * 用户的收货地址操作
     * @param address
     * @return
     */
    @Login
    @RequestMapping(value = "saveAddress")
    @ResponseBody
    public Object saveAddress(@RequestBody Address address){
        Address currentAddress = productionService.isExistAddress(address.getId());
        if(address.getAddressStatus() == 0){
            productionService.updateState(address.getId(),address.getUserId());
        }
        if(currentAddress == null){
            productionService.saveAddress(address);
        }else{
            productionService.updateAddress(address);
        }
        return new Result().success();
    }

    /**
     * 获取用户默认的收货地址
     * @param entity
     * @return
     */
    @Login
    @RequestMapping(value = "getDefaultAddress")
    @ResponseBody
    public Object getDefaultAddress(@RequestBody UserEntity entity){
        Address address = productionService.getDefaultAddress(entity.getId());
        return new Result().ok(address);
    }

    /**
     *  获取用户的所有收获地址
     * @param entity
     * @return
     */
    @Login
    @RequestMapping(value = "getAddress")
    @ResponseBody
    public Object getAddress(@RequestBody UserEntity entity){
        List<Address> address = productionService.getAddress(entity.getId());
        return new Result().ok(address);
    }
}