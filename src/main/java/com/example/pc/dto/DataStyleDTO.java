package com.example.pc.dto;

import lombok.Data;

import java.util.List;

@Data
public class DataStyleDTO {
    private  String title;
    private List<ProductDTO> style;
}
