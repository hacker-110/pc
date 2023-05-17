package com.example.pc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateDTO<T> {

    @ApiModelProperty(value = "状态码")
    /**
     * 返回状态码
     */
    private Integer code;

    @ApiModelProperty(value = "数据")
    /**
     * 返回数据
     */
    private T data ;


    @ApiModelProperty(value = "响应信息")
    /**
     * 返回消息
     */
    private String message;


    //成功返回
    public static <T> StateDTO<T> success(Integer code, T data ) {
        return new StateDTO(code , data  , "");
    }
    //失败返回
    public static <T> StateDTO<T> error(Integer code, String message) {
        return new StateDTO(code, null,  message);
    }

}
