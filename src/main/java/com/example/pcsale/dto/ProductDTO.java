package com.example.pcsale.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {
    private String id;
    private String brand;
    private String name;
    private String processor;
    private String storage;
    private String ram;
    private String additionalFeatures;
    private String condition;
    private String price;
    private String image;

    public ProductDTO(String brand, String name, String price) {
        this.brand = brand;
        this.name = name;
        this.price = price;
    }
}

