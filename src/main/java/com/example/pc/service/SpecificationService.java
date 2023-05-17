package com.example.pc.service;

import com.example.pc.dto.ProductDTO;
import com.example.pc.dto.SpecificationDTO;
import com.example.pc.mapper.SpecificationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//商品规格管理
@Service
public class SpecificationService {

    @Resource
    private SpecificationMapper specificationMapper;

     //分类格式输出
    private void addStyle(List<Map<String, Object>> list, String titleKey, String styleKey, List<ProductDTO> products) {
        if (!products.isEmpty()) {
            Map<String, Object> map = new HashMap<>();
            map.put(titleKey, products.get(0).getCategory());
            map.put(styleKey, products);
            list.add(map);
        }
    }
    //查询商品规格
    public  List<Map<String, Object>> ProductStyle( Integer product_id){
        List<Map<String, Object>> list = new ArrayList<>();
        addStyle(list, "title", "style", specificationMapper.selectProductStyle(product_id));
        addStyle(list, "title", "style", specificationMapper.selectProductColor(product_id));
        addStyle(list, "title", "style", specificationMapper.selectProductSize(product_id));
        return list;
    }


    //商品所属信息
    public   List<SpecificationDTO>  SpecificationList(Integer product_id){
        List<SpecificationDTO>  Specification = specificationMapper.selectSpecificationDTO(product_id);
        return Specification;
    }
}
