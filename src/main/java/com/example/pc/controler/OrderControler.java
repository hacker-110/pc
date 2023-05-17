package com.example.pc.controler;

import com.example.pc.config.token.JwtToken;
import com.example.pc.dto.StateDTO;
import com.example.pc.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//订单管理
@RestController
@RequestMapping("/api/pc/order")
@Api(tags = "订单管理")
public class OrderControler {
    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "订单列表")
    @GetMapping("/orderList")
    @JwtToken
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nickName",value = "小程序用户名称"),
            @ApiImplicitParam(name = "name",value = "商品名称"),
            @ApiImplicitParam(name = "state",value = "商品分类状态"),
            @ApiImplicitParam(name = "PageNum",value = "PageNum",required = true),
            @ApiImplicitParam(name = "PageSize",value = "PageSize",required = true)
    })
    public StateDTO orderList(
            @RequestParam(value = "nickName" ,required = false) String nickName,
            @RequestParam(value = "name" ,required = false) String name,
            @RequestParam(value = "state" ,required = false) String state,
            @RequestParam(value = "PageNum" ) Integer PageNum,
            @RequestParam(value = "PageSize" ) Integer PageSize
          ){
        Map<String , Object> map = orderService.OraderList(nickName,name,state,PageNum,PageSize);
        return StateDTO .success(200 , map);
    }
}
