package com.example.pc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("商品列表")
public class ClassifyListDTO {
    @ApiModelProperty(value = "id")
    private  Integer  id;
    @ApiModelProperty(value = "商品名称")
    private  String  name;
    @ApiModelProperty(value = "商品价格")
    private BigDecimal price;
    @ApiModelProperty(value = "商品描述")
    private  String  introduce;
    @ApiModelProperty(value = "商品图片")
    private  String  img_url;
    @ApiModelProperty(value = "是否置顶")
    private  String  top;
    @ApiModelProperty(value = "商品分类")
    private  String  state;
    @ApiModelProperty(value = "商品状态")
    private  String product_status;
    @ApiModelProperty(value = "创建时间")
    private  String create_time;
}
