package com.example.pc.service.utils;

import com.example.pc.dto.StateDTO;
import com.example.pc.exception.Errors;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Component
public class UploadFile {
    @Value("${qiniu.accessKey}")
    private  String accessKey;      //公钥
    @Value("${qiniu.secretKey}")
    private  String accessSecretKey;   //私钥
    @Value("${qiniu.bucket}")
    private  String bucket;   // 存储空间
    @Value("${qiniu.url}")//# 域名/路径
    private String url;

    //处理多文件
    public Map<String, List<String>> uploadImages(MultipartFile[] multipartFiles , String key){
        Map<String, List<String>> map = new HashMap<>();
        List<String> imageUrls = new ArrayList<>();
        for(MultipartFile file : multipartFiles){
            imageUrls.add(uploadImageQiniu(file , key));
        }
        map.put("imageUrl",imageUrls);
        return map;
    }

    //上传图片到七牛云
    public String uploadImageQiniu(MultipartFile multipartFile ,String key){
        try {
            //1、获取文件上传的流
            byte[] fileBytes = multipartFile.getBytes();
            //2、上传指定的路径
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//            String datePath = dateFormat.format(new Date());
            //3、获取文件名
            String originalFilename = multipartFile.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String filename = key+ UUID.randomUUID().toString().replace("-", "")+ suffix;
            //4.构造一个带指定 Region 对象的配置类
            com.qiniu.storage.Configuration cfg = new com.qiniu.storage.Configuration(Region.huadong());
            UploadManager uploadManager = new UploadManager(cfg);
            //5.获取七牛云提供的 token
            Auth auth = Auth.create(accessKey, accessSecretKey);
            String upToken = auth.uploadToken(bucket);
            uploadManager.put(fileBytes,filename,upToken);
            return url+filename;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //统一返回
    public StateDTO uploadFile(MultipartFile file , String key){
        if (ObjectUtils.isEmpty(file)) {
            throw new Errors(500, "文件不能为空！" );
        }
        String url = uploadImageQiniu(file,key);
        return StateDTO.success(200, url);
    }
}
