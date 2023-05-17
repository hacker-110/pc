package com.example.pc.service;

import com.example.pc.dto.OrderListDTO;
import com.example.pc.mapper.OrderMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//订单管理
@Service
public class OrderService {
    @Resource
    private OrderMapper orderMapper;

    //订单列表
    public Map<String , Object> OraderList(
                          String nickName,
                          String name,
                          String state,
                          Integer PageNum,
                          Integer PageSize){
        PageHelper.startPage(PageNum, PageSize);
        List<OrderListDTO> list =  orderMapper.selectOrader(nickName,name,state);
        PageInfo<OrderListDTO> pageInfo = new PageInfo<>(list);
        Map<String , Object> map = new HashMap<>();
        map.put("list",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return   map ;
    }

}
