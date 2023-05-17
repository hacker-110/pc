package com.example.pc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品规格信息")
public class ProductDTO {
    @ApiModelProperty(value = "id")
    private  String id;
    @ApiModelProperty(value = "所属商品ID")
    private  Integer  product_id;
    @ApiModelProperty(value = "规格名称")
    private  String  name;
    @ApiModelProperty(value = "规格类型")
    private  String  category;
    @ApiModelProperty(value = "规格层级")
    private  String  state;
    @ApiModelProperty(value = "规格图片")
    private  String  img_url;
}
