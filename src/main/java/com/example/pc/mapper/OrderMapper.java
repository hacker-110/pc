package com.example.pc.mapper;

import com.example.pc.dto.OrderListDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//订单管理
public interface OrderMapper {
//订单列表
    List<OrderListDTO>  selectOrader(
            @Param("nickName") String nickName,
            @Param("name") String name,
            @Param("state") String state
    );

}
