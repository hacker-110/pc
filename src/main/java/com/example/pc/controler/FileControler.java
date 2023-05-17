package com.example.pc.controler;

import com.example.pc.config.token.JwtToken;
import com.example.pc.dto.StateDTO;
import com.example.pc.service.utils.UploadFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/pc/file")
@Api(tags = "上传文件或图片")
public class FileControler {

    @Autowired
    private UploadFile uploadfile;


    //上传图片
    @PostMapping("/imges")
    @ApiOperation(value = "上传图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file",value = "file",required = true),
    })
    @JwtToken()
    public StateDTO uploadImage(@RequestBody  MultipartFile file){
        return uploadfile.uploadFile(file , "image/");
    }

    //上传文件
    @PostMapping("/upload")
    @ApiOperation(value = "上传文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file",value = "file",required = true),
    })
    @JwtToken()
    public StateDTO handleFileUpload(@RequestBody MultipartFile file)  {
        return uploadfile.uploadFile(file , "file/");
    }
}
