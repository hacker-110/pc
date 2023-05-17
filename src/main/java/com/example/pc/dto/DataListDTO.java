package com.example.pc.dto;

import lombok.Data;

import java.util.List;

@Data
public class DataListDTO {
    private   ClassifyListDTO  commodity ;
    private  List<DataStyleDTO> list ;
    private  List<SpecificationDTO> table;
}
