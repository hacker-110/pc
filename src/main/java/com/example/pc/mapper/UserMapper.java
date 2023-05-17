package com.example.pc.mapper;

import com.example.pc.dto.WxUserInfoDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//用户管理
public interface UserMapper {

    //用户列表
    List<WxUserInfoDTO> selectUserInfo(
            @Param("nickName") String nickName
    );

}
