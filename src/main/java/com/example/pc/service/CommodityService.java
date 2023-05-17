package com.example.pc.service;

import com.example.pc.dto.ClassifyDTO;
import com.example.pc.dto.ClassifyListDTO;
import com.example.pc.dto.DataListDTO;
import com.example.pc.dto.SpecificationDTO;
import com.example.pc.mapper.CommodityMapper;
import com.example.pc.mapper.SpecificationMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//商品管理
@Service
public class CommodityService {
    @Resource
    private CommodityMapper commodityMapper;

    @Resource
    private SpecificationMapper specificationMapper;

    @Autowired
    private SpecificationService specificationService;
    //新增商品分类
    public  Integer  addCommodityList(ClassifyDTO classifyDTO){
        return commodityMapper.addCommodity(classifyDTO);
    }

    //    商品分类列表
    public List<ClassifyDTO> CommodityList(){
        return commodityMapper.selectCommodityList();
    }
    //    商品列表
    public  Map<String,Object>  CommodityLists(String name ,String state , Integer PageNum , Integer PageSize){
        PageHelper.startPage(PageNum, PageSize);
        List<ClassifyListDTO> list =  commodityMapper.selectCommodityLists(name,state);
        PageInfo<ClassifyListDTO> pageInfo = new PageInfo<>(list);
        Map<String,Object> map = new HashMap<>();
        map.put("list",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }
    //    商品编辑和新增处理
    private Integer ProductStyleList(DataListDTO dataListDTO , Integer type){
      try {
          List<String> list = new ArrayList<>();
          List<String> list1 = new ArrayList<>();
          List<String> list2 = new ArrayList<>();
          List<Integer> list3 = new ArrayList<>();
          Integer commodityId = dataListDTO.getCommodity().getId();
          dataListDTO.getList().get(0).getStyle().forEach(item -> item.setProduct_id(commodityId));
            if(type.equals(2)) {
                dataListDTO.getList().get(0).getStyle().forEach(item -> list.add(item.getId()));
                specificationMapper.deleteProductListOne( commodityId ,list);
            }
          specificationMapper.addProductStyle(dataListDTO.getList().get(0).getStyle());
          if(dataListDTO.getList().size() >= 2) {
              dataListDTO.getList().get(1).getStyle().forEach(item -> item.setProduct_id(commodityId));
              if(type.equals(2)) {
                  dataListDTO.getList().get(1).getStyle().forEach(item -> list1.add(item.getId()));
                  specificationMapper.deleteProductListTwo(commodityId,list1);
              }
              specificationMapper.addProductColor(dataListDTO.getList().get(1).getStyle());
          }
          if (dataListDTO.getList().size() >= 3) {
              dataListDTO.getList().get(2).getStyle().forEach(item -> item.setProduct_id(commodityId));
              if(type.equals(2)) {
                  dataListDTO.getList().get(2).getStyle().forEach(item -> list2.add(item.getId()));
                  specificationMapper.deleteProductListThree(commodityId,list2);
              }
              specificationMapper.addProductSize(dataListDTO.getList().get(2).getStyle());
          }
          dataListDTO.getTable().forEach(item -> item.setProduct_id(commodityId));
          if(type.equals(2)) {
              dataListDTO.getTable().forEach(item -> list3.add(item.getId()));
              specificationMapper.deleteSpecifications(commodityId,list3);
          }
          specificationMapper.addSpecificationDTO(dataListDTO.getTable());
          return  1;
      }
      catch (Exception e) {
          return  0;
      }
    }
    //    商品新增
    public  Integer  addCommodityLists(DataListDTO dataListDTO){
        commodityMapper.addCommodityList( dataListDTO.getCommodity());
        return ProductStyleList(dataListDTO ,1);
    }
    //    商品编辑
    public  Integer  updateCommodityLists(DataListDTO dataListDTO){
        commodityMapper.updateCommodityList(dataListDTO.getCommodity());
        return ProductStyleList(dataListDTO , 2);
    }
    //    商品详情查询
    public   Map<String, Object>  DetailsCommodityLists(Integer id){
        List<Map<String, Object>> list  = specificationService.ProductStyle(id);
        List<SpecificationDTO> list1  = specificationService.SpecificationList(id);
        Map<String, Object> map = new HashMap<>();
        map.put("commodity",commodityMapper.selectDetailsCommodityList(id));
        map.put("list",list);
        map.put("table",list1);
        return map;
    }
    //    商品删除
    public  Integer  deleteCommodityLists(Integer id){
     try {
         commodityMapper.deleteCommodityList(id);
         specificationMapper.deleteProductStyle(id);
         specificationMapper.deleteProductColor(id);
         specificationMapper.deleteProductSize(id);
         specificationMapper.deleteSpecificationDTO(id);
         return  1;
     }
       catch (Exception e) {
           return  0;
       }
    }
}
