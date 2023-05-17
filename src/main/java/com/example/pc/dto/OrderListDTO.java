package com.example.pc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("订单列表")
public class OrderListDTO {
    @ApiModelProperty(value = "id")
    private  Integer id;
    @ApiModelProperty(value = "小程序用户id")
    private  String  openid;
    @ApiModelProperty(value = "商品名称")
    private  String  name;
    @ApiModelProperty(value = "商品价格")
    private BigDecimal price;
    @ApiModelProperty(value = "购买数量")
    private  Integer  num;
    @ApiModelProperty(value = "商品图片")
    private  String  img_url;
    @ApiModelProperty(value = "商品分类状态")
    private  String  state;
    @ApiModelProperty(value = "小程序用户名称")
    private  String  nickName;
    @ApiModelProperty(value = "小程序用户头像")
    private  String  avatarUrl;
    @ApiModelProperty(value = "创建时间")
    private  String  create_time;

}
