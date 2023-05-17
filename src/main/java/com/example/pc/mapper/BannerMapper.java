package com.example.pc.mapper;

import com.example.pc.dto.BannerDTO;

import java.util.List;

//Banner管理
public interface BannerMapper {
//    banner列表
List<BannerDTO> selectBannerList();
//    banner添加
    Integer addInsertBanner(
            BannerDTO bannerDTO
    );

    //    banner编辑
    Integer updateInsertBanner(
            BannerDTO bannerDTO
    );
//    banner删除
    Integer deleteInsertBanner(Integer id);
}

