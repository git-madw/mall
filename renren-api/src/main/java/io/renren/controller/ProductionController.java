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
import java.util.List;

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
        for(ObjectCommodity commodity : productions){
            String commodityId = commodity.getId();
            List<CommodityColor> commodityColor = productionService.getCommodityColor(commodityId);
            List<CommodityVersion> commodityVersion = productionService.getCommodityVersion(commodityId);
            ObjectCommodityInfo info = new ObjectCommodityInfo();
            info.setCommodityColors(commodityColor);
            info.setCommodityVersions(commodityVersion);
            commodity.setObjectCommodityInfo(info);
        }
        return new Result().ok(productions);
    }
}