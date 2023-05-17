package com.example.pc.controler;

import com.example.pc.config.token.JwtToken;
import com.example.pc.dto.BannerDTO;
import com.example.pc.dto.StateDTO;
import com.example.pc.exception.Errors;
import com.example.pc.service.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//Banner管理
@RestController
@RequestMapping("/api/pc/banner")
@Api(tags = "Banner管理")
public class BannerControler {
    @Autowired
    private BannerService bannerService;

    @ApiOperation(value = "Banner列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "PageNum",value = "PageNum",required = true),
            @ApiImplicitParam(name = "PageSize",value = "PageSize",required = true),
    })
    @GetMapping("/bannerList")
    @JwtToken
    public StateDTO bannerList(
            @RequestParam(value = "PageNum" ) Integer PageNum,
            @RequestParam(value = "PageSize" ) Integer PageSize
    ){
        Map<String , Object> map =bannerService.bannerList(PageNum , PageSize);
        return  StateDTO.success(200 , map);
    }


    @ApiOperation(value = "Banner新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bannerUrl",value = "轮播图地址",required = true),
            @ApiImplicitParam(name = "bannerName",value = "轮播图名称",required = true),
    })
    @PostMapping("/addBannerList")
    @JwtToken
    public StateDTO addbannerList(
            @RequestBody BannerDTO bannerDTO
    ){
      Integer num =  bannerService.AddBanner(bannerDTO);
      if(num == 0){
          throw  new Errors(500 , "新增失败");
        }
        else {
          return  StateDTO.success(200 , "");
        }

    }


    @ApiOperation(value = "Banner编辑")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "编辑id",required = true),
            @ApiImplicitParam(name = "bannerUrl",value = "轮播图地址",required = true),
            @ApiImplicitParam(name = "bannerName",value = "轮播图名称",required = true),
    })
    @PutMapping("/updateBannerList")
    @JwtToken
    public StateDTO updatebannerList(
            @RequestBody BannerDTO bannerDTO
    ){
        Integer num =  bannerService.updateBanner(bannerDTO);
        if(num == 0){
            throw  new Errors(500 , "编辑失败");
        }
        else {
            return  StateDTO.success(200 , "");
        }

    }

    @ApiOperation(value = "Banner删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "删除id",required = true),
    })
    @DeleteMapping ("/deleteBannerList/{id}")
    @JwtToken
    public StateDTO deletebannerList(
            @PathVariable(value = "id") Integer id
    ){
        Integer num =  bannerService.deleteBanner(id);
        if(num == 0){
            throw  new Errors(500 , "删除失败");
        }
        else {
            return  StateDTO.success(200 , "");
        }

    }
}
