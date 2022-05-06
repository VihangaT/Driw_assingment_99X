package com.driw.assingment.shop.driw_shop.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private long productId;
    private String productName;
    private int itemsPerCarton;
    private double cartonPrice;
}
