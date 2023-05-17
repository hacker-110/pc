package com.example.pc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品分类")
public class ClassifyDTO {

    @ApiModelProperty(value = "id")
    private  Integer id;
    @ApiModelProperty(value = "分类名称")
    private  String  moduleName;

}
