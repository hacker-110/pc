package com.example.pc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("登录用户信息")
public class PcUserInfoDTO {
    @ApiModelProperty(value = "id")
    private  Integer id;
    @ApiModelProperty(value = "用户名")
    private  String  user_name;
    @ApiModelProperty(value = "密码")
    private  String  password;

    @ApiModelProperty(value = "头像")
    private  String  img_url;

    @ApiModelProperty(value = "创建时间")
    private  String  create_time;
}
