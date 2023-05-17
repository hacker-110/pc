package com.example.pc.service;

import com.example.pc.dto.BannerDTO;
import com.example.pc.mapper.BannerMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Banner管理
@Service
public class BannerService {
    @Resource
    private BannerMapper bannerMapper;

    //    banner列表
    public Map<String , Object> bannerList(Integer PageNum, Integer PageSize) {
        PageHelper.startPage(PageNum, PageSize);
        List<BannerDTO> list = bannerMapper.selectBannerList();
        PageInfo<BannerDTO> pageInfo = new PageInfo<>(list);
        Map<String , Object> map = new HashMap<>();
        map.put("list" ,pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return  map;
    };

    //    banner添加
    public Integer AddBanner( BannerDTO bannerDTO){
        return  bannerMapper.addInsertBanner(bannerDTO);
    };
    //    banner编辑
    public Integer updateBanner(BannerDTO bannerDTO){
        return bannerMapper.updateInsertBanner(bannerDTO);
    }
    //    banner删除
    public Integer deleteBanner(Integer id){
        return bannerMapper.deleteInsertBanner( id );
    }
}
