package com.example.pc.controler;

import com.example.pc.config.token.JwtToken;
import com.example.pc.dto.StateDTO;
import com.example.pc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//用户管理
@RestController
@RequestMapping("/api/pc/user")
@Api(tags = "用户管理")
public class UserControler {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nickName",value = "用户名"),
            @ApiImplicitParam(name = "PageNum",value = "PageNum",required = true),
            @ApiImplicitParam(name = "PageSize",value = "PageSize",required = true),
    })
    @GetMapping("/userList")
    @JwtToken
    public StateDTO userList(
            @RequestParam(value = "nickName" ,required = false) String nickName,
            @RequestParam(value = "PageNum" ) Integer PageNum,
            @RequestParam(value = "PageSize") Integer PageSize
    ){
        Map<String , Object> map =  userService.UserInfoList(nickName ,PageNum ,PageSize);
        return  StateDTO.success(200 , map);

    }
}
