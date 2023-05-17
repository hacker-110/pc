package com.example.pc.mapper;


import com.example.pc.dto.ClassifyDTO;
import com.example.pc.dto.ClassifyListDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//商品管理
public interface CommodityMapper {
//    商品分类新增
    Integer addCommodity(ClassifyDTO classifyDTO);
//    商品分类列表
    List<ClassifyDTO> selectCommodityList();

//    商品列表
List<ClassifyListDTO>  selectCommodityLists(
                                            @Param("name") String name ,
                                            @Param("state") String state
                                          );
//    商品新增
 Integer addCommodityList (ClassifyListDTO classifyListDTO);
//    商品编辑
Integer updateCommodityList (ClassifyListDTO classifyListDTO);
//    商品详情查询
ClassifyListDTO selectDetailsCommodityList (@Param("id") Integer id);
//    商品删除
Integer deleteCommodityList (@Param("id") Integer id);
}
