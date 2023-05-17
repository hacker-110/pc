package com.example.pc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("商品所属规格信息")
public class SpecificationDTO {
    @ApiModelProperty(value = "id")
    private  Integer id;
    @ApiModelProperty(value = "所属商品ID")
    private  Integer  product_id;
    @ApiModelProperty(value = "一级规格名称")
    private  String  style_id;
    @ApiModelProperty(value = "二级规格名称")
    private  String  color_id;
    @ApiModelProperty(value = "三级规格名称")
    private  String  size_id;
    @ApiModelProperty(value = "规格价格")
    private BigDecimal price;
}
