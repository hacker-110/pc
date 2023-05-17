package com.example.pc.controler;


import com.example.pc.config.token.JwtUtil;
import com.example.pc.dto.StateDTO;
import com.example.pc.dto.PcUserInfoDTO;
import com.example.pc.exception.Errors;
import com.example.pc.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//登录
@RestController
@RequestMapping("/api/pc")
@Api(tags = "管理系统登录")
public class LoginControler {
    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",value = "用户名",required = true),
            @ApiImplicitParam(name = "password",value = "密码",required = true),
    })
  @GetMapping("/login")
  public StateDTO login(
          @RequestParam(value = "userName") String userName,
          @RequestParam(value = "password") String password
    )  {
        PcUserInfoDTO user =  loginService.getLogin(userName  ,  password);
        if (user !=null) {
            Map<String , Object> map  =  new HashMap<>();
            map.put("token", JwtUtil.sign(user.getUser_name()));
            map.put("user",user);
            return  StateDTO.success(200,map);
        }
        else {
            throw new Errors( 500,"账号或密码错误！");
        }

    }
}
