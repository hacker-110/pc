package com.example.pc.controler;

import com.example.pc.config.token.JwtToken;
import com.example.pc.dto.ClassifyDTO;
import com.example.pc.dto.DataListDTO;
import com.example.pc.dto.StateDTO;
import com.example.pc.exception.Errors;
import com.example.pc.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//商品分类
@RestController
@RequestMapping("/api/pc/commodity")
@Api(tags = "商品管理")
public class CommodityControler {
    @Autowired
    private CommodityService commodityService;

    @ApiOperation(value = "商品分类列表")
    @GetMapping("/commodityList")
    @JwtToken
    public StateDTO  commodityList(){
     return StateDTO.success(200 , commodityService.CommodityList());
    }
    @ApiOperation(value = "商品分类新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "moduleName",value = "分类名称",required = true),
    })
    @PostMapping("/addCommodityList")
    @JwtToken
    public StateDTO  addcommodityList(
            @RequestBody ClassifyDTO classifyDTO
    ){
        Integer num =  commodityService.addCommodityList(classifyDTO);

        if(num == 0){
            throw  new Errors(500 , "新增失败");
        }
        else {
          return   StateDTO.success(200 , "");
        }
    }

    @ApiOperation(value = "商品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "商品名称"),
            @ApiImplicitParam(name = "state",value = "商品分类"),
            @ApiImplicitParam(name = "PageNum",value = "PageNum",required = true),
            @ApiImplicitParam(name = "PageSize",value = "PageSize",required = true)
    })
    @GetMapping("/commodityLists")
    @JwtToken
    public StateDTO  commodityLists(
        @RequestParam(value = "name" , required = false) String name,
        @RequestParam(value = "state", required = false) String state,
        @RequestParam(value = "PageNum") Integer PageNum,
        @RequestParam(value = "PageSize") Integer PageSize
    ){
      return StateDTO.success(200 , commodityService.CommodityLists(name,state,PageNum,PageSize));
    }

    @ApiOperation(value = "商品新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "商品名称",required = true),
            @ApiImplicitParam(name = "price",value = "商品价格",required = true),
            @ApiImplicitParam(name = "introduce",value = "商品描述",required = true),
            @ApiImplicitParam(name = "img_url",value = "商品图片",required = true),
            @ApiImplicitParam(name = "top",value = "是否置顶",required = true),
            @ApiImplicitParam(name = "state",value = "商品分类",required = true),
            @ApiImplicitParam(name = "product_status",value = "商品状态",required = true)
    })
    @PostMapping("/addCommodityLists")
    @JwtToken
    public StateDTO   add(
            @RequestBody DataListDTO dataListDTO
    ){
        Integer num =  commodityService.addCommodityLists(dataListDTO);

        if(num == 0){
            throw  new Errors(500 , "新增失败");
        }
        else {
            return   StateDTO.success(200 , "");
        }
    }


    @ApiOperation(value = "商品编辑")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "商品id",required = true),
            @ApiImplicitParam(name = "name",value = "商品名称",required = true),
            @ApiImplicitParam(name = "price",value = "商品价格",required = true),
            @ApiImplicitParam(name = "introduce",value = "商品描述",required = true),
            @ApiImplicitParam(name = "img_url",value = "商品图片",required = true),
            @ApiImplicitParam(name = "top",value = "是否置顶",required = true),
            @ApiImplicitParam(name = "state",value = "商品分类",required = true),
            @ApiImplicitParam(name = "product_status",value = "商品状态",required = true)
    })
    @PutMapping("/updateCommodityList")
    @JwtToken
    public StateDTO  updatecommodityLists(
            @RequestBody DataListDTO dataListDTO
    ){
        Integer num =  commodityService.updateCommodityLists(dataListDTO);

        if(num == 0){
            throw  new Errors(500 , "编辑失败");
        }
        else {
            return   StateDTO.success(200 , "");
        }
    }


    @ApiOperation(value = "商品详情查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "商品id",required = true),
    })
    @GetMapping("/detailsCommodityList")
    @JwtToken
    public StateDTO  detailscommodityList(
           @RequestParam(value = "id") Integer id
    ){
     return  StateDTO.success(200 , commodityService.DetailsCommodityLists(id));
    }

    @ApiOperation(value = "商品删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "商品id",required = true),
    })
    @DeleteMapping ("/deleteCommodityList/{id}")
    @JwtToken
    public StateDTO  deletecommodityLists(
           @PathVariable(value = "id") Integer id
    ){
        Integer num =  commodityService.deleteCommodityLists(id);

        if(num == 0){
            throw  new Errors(500 , "删除失败");
        }
        else {
            return   StateDTO.success(200 , "");
        }
    }

}
