package com.example.pc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("轮播图")
public class BannerDTO {
    @ApiModelProperty(value = "id")
    private  Integer id;
    @ApiModelProperty(value = "轮播图地址")
    private  String  bannerUrl;
    @ApiModelProperty(value = "轮播图名称")
    private  String  bannerName;

}
