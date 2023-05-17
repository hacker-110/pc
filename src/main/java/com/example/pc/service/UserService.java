package com.example.pc.service;

import com.example.pc.dto.WxUserInfoDTO;
import com.example.pc.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//订单管理
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    //用户列表
public Map<String , Object> UserInfoList(String nickName ,Integer PageNum ,Integer PageSize) {
    PageHelper.startPage(PageNum, PageSize);
    List<WxUserInfoDTO> list = userMapper.selectUserInfo(nickName);
    PageInfo<WxUserInfoDTO> pageInfo = new PageInfo<>(list);
    Map<String , Object> map = new HashMap<>();
    map.put("list" ,pageInfo.getList());
    map.put("total",pageInfo.getTotal());
    return map;
}
}
