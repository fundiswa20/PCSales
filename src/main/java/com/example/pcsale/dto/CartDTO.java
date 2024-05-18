package com.example.pcsale.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private String total;
    private String numberOfItems;
    private List<ProductDTO> products = new ArrayList<>();
}
