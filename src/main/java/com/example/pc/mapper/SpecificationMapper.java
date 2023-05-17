package com.example.pc.mapper;

import com.example.pc.dto.ProductDTO;
import com.example.pc.dto.SpecificationDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//商品规格管理
public interface SpecificationMapper {
//    一级分类
List<ProductDTO> selectProductStyle(
            @Param("product_id") Integer product_id
            );
//    二级分类
List<ProductDTO> selectProductColor(
            @Param("product_id") Integer product_id
    );
//    三级分类
List<ProductDTO> selectProductSize(
            @Param("product_id") Integer product_id
    );
//    新增一级分类
    Integer addProductStyle(
            List <ProductDTO> list
    );
//    新增二级分类
    Integer addProductColor(
            List <ProductDTO> list
    );
//    新增三级分类
    Integer addProductSize(
            List <ProductDTO> list
    );

    //    删除一级分类子规格
    Integer deleteProductStyle(
          @Param("product_id") Integer product_id
    );
    //    删除二级分类子规格
    Integer deleteProductColor(
            @Param("product_id") Integer product_id
    );
    //    删除三级分类子规格
    Integer deleteProductSize(
            @Param("product_id") Integer product_id
    );

    //    删除一级分类规格
    Integer deleteProductListOne(
            @Param("product_id") Integer product_id,
            @Param("list") List<String> list
    );

    //    删除二级分类规格
    Integer deleteProductListTwo(
            @Param("product_id") Integer product_id,
            @Param("list") List<String> list
    );

    //    删除三级分类规格
    Integer deleteProductListThree(
            @Param("product_id") Integer product_id,
            @Param("list") List<String> list
    );
//    商品所属规格查询
   List<SpecificationDTO> selectSpecificationDTO(
           @Param("product_id") Integer product_id
   );
//    新增商品所属规格查询
      Integer addSpecificationDTO(
        List<SpecificationDTO> list
        );

    // 删除商品所属规格
    Integer deleteSpecificationDTO(
            @Param("product_id") Integer product_id
    );

    // 更具层级删除组合规格
    Integer deleteSpecifications (
            @Param("product_id") Integer product_id,
            @Param("list") List<Integer> list
    );
}
