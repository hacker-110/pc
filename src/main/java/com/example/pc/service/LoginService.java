package com.example.pc.service;

import com.example.pc.dto.PcUserInfoDTO;
import com.example.pc.mapper.LoginMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//登录
@Service
public class LoginService {

    @Resource
    private LoginMapper loginMapper;


    //登录
    public PcUserInfoDTO getLogin(String username, String password){
        return loginMapper.getLogin(username,password);
    }
}
