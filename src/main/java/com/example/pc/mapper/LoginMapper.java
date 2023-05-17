package com.example.pc.mapper;


import com.example.pc.dto.PcUserInfoDTO;

//登录
public interface LoginMapper {
    PcUserInfoDTO getLogin(String userName, String password);
}
