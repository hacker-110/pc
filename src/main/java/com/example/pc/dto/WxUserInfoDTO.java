package com.example.pc.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("微信用户信息")
//微信用户信息
public class WxUserInfoDTO {
    @ApiModelProperty(value = "用户id")
    private Integer id;

    @ApiModelProperty(value = "微信用户昵称")
    private String nickName;

    @ApiModelProperty(value = "微信用户性别")
    private Integer gender;

    @ApiModelProperty(value = "微信用户所在地址")
    private String city;

    @ApiModelProperty(value = "微信用户头像地址")
    private String avatarUrl;

    @ApiModelProperty(value = "微信用户创建时间")
    private  String create_time;
}
